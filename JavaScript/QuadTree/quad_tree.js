/*
Given a list of points and a query list representing the bottom left and top right points of a rectangle
Return how many points are in each rectangular query
*/

class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    constructor(x, y, w, h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    contains(point) {
        return this.x - this.w <= point.x && 
               this.x + this.w >= point.x &&
               this.y - this.h <= point.y &&
               this.y + this.h >= point.y;
    }

    intersects(range) {
        return !(range.x - range.w > this.x + this.w ||
        range.x + range.w < this.x - this.w ||
        range.y - range.h > this.y + this.h ||
        range.y + range.h < this.y - this.h);
    }
}

class QuadTree {
    constructor(boundary, capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.points = [];
        this.divided = false;
    }

    insert(point) {
        //check if the point is bounded by this tree
        if(this.boundary.contains(point) == false) {
            return false;
        }

        //check if this tree has enough capacity for the point
        if(this.points.length < this.capacity) {
            this.points.push(point);
            return true;
        }
        else{
            if(this.divided == false) {
                this.subdivide();
            }

            return this.northWest.insert(point) ||
            this.northEast.insert(point) ||
            this.southEast.insert(point) ||
            this.southWest.insert(point);
        }
    }

    subdivide(rectangle) {
        let x = this.boundary.x;
        let y = this.boundary.y;
        let w = this.boundary.w;
        let h = this.boundary.h;

        let se = new Rectangle(x + w/2, y + h/2, w/2, h/2);
        this.southEast = new QuadTree(se, this.capacity);      

        let sw = new Rectangle(x - w/2, y + h/2, w/2, h/2);
        this.southWest = new QuadTree(sw, this.capacity);
        
        let ne = new Rectangle(x + w/2, y - h/2, w/2, h/2);
        this.northEast = new QuadTree(ne, this.capacity);

        let nw = new Rectangle(x - w/2, y - h/2, w/2, h/2);
        this.northWest = new QuadTree(nw, this.capacity);

        this.divided = true;
    }

    size() {
        if(this.divided) {
            return this.points.length + this.northWest.size() + this.northEast.size() + this.southEast.size() + this.southWest.size();
        }
        else {
            return this.points.length;
        }
    }

    countInRange(range) {
        if(this.boundary.intersects(range) == false) {
            return 0
        } else {
            let count = 0;
            for(let p of this.points) {
                count += range.contains(p);
            }
            
            if(this.divided) {
                return count 
                + this.northWest.countInRange(range) 
                + this.northEast.countInRange(range)
                + this.southEast.countInRange(range)
                + this.southWest.countInRange(range);
            }
            else {
                return count;
            }
        }
    }

    pointsInRange(range, points = []) {
        if(this.boundary.intersects(range) == false) {
            return points
        } else {
            for(let p of this.points) {
                if(range.contains(p)) {
                    points.push(p);
                }
            }
            if(this.divided) {
                this.northWest.pointsInRange(range, points); 
                this.northEast.pointsInRange(range, points);
                this.southEast.pointsInRange(range, points);
                this.southWest.pointsInRange(range, points);
            }
        }
        return points;
    }

    show() {
        strokeWeight(1);
        stroke(255);
        
        noFill();
        rect(this.boundary.x, this.boundary.y, this.boundary.w*2, this.boundary.h*2);

        rectMode(CENTER);

        if(this.divided) {
            this.northEast.show();
            this.northWest.show();
            this.southWest.show();
            this.southEast.show();
        }

        for(let p of this.points) {
            strokeWeight(1);
            point(p.x, p.y);
        }

        strokeWeight(1);
    }
}
