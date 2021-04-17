/*
Given a list of points and a query list representing the bottom left and top right points in a rectangle
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
}

class QuadTree {
    constructor(boundary) {
        this.boundary = boundary;
    }
}