setup = () => {
    
    const width = 400;
    const height = 400;
    
    createCanvas(width, height);

    let boundary = new Rectangle(200, 200, 200, 200);
    let quadTree = new QuadTree(boundary);
    
    for(let i = 0; i < 1; i++) {
        let p = new Point(random(width), random(height));
    }

    

}
