let quadTree;
let universePoints = [];
const width = 1_000;
const height = 1_000;

setup = () => {
    

    
    createCanvas(width, height);

    let boundary = new Rectangle(width/2, height/2, width/2, height/2);
    quadTree = new QuadTree(boundary, 4);
    
    for(let i = 0; i < 7_000; i++) {
        let p = new Point(random(1e8)|0, random(1e6)|0);
        quadTree.insert(p);
        point(p.x, p.y);
        universePoints.push([p.x, p.y]);
    }

    //console.log(quadTree);
    //console.log(quadTree.size());
    console.log("[["+universePoints.join("],[")+"]]");
    
    background(0);
    quadTree.show();
    console.log("done");

    
    background(0);
    quadTree.show();

    diffA = 50;
    diffB = 50;
    console.log(diffA, diffB);
    console.log(relativeJobs(universePoints, diffA, diffB));
    console.log(relativeJobsHard2(universePoints, diffA, diffB));

    // let range = new Rectangle(20, 20, 5, 5);

    // stroke(0, 255, 0);
    // rect(range.x, range.y, range.w*2, range.h*2);

    // let points = quadTree.pointsInRange(range);
    // console.log(points);
    // for(let p of points) {
    //     stroke(0, 255, 0);
    //     strokeWeight(4);
    //     point(p.x, p.y);
    // }
        
    
}

// draw = () => {
//     background(0);
//     quadTree.show();

//     let range = new Rectangle(mouseX, mouseY, 5, 5);

//     stroke(0, 255, 0);
//     rect(range.x, range.y, range.w*2, range.h*2);

//     let points = quadTree.pointsInRange(range);
//     console.log(points);
//     for(let p of points) {
//         stroke(0, 255, 0);
//         strokeWeight(4);
//         point(p.x, p.y);
//     }
    
// }

function relativeJobs(jobs, wageOffset, hourlyOffset) {
    console.time("relativeJobs");
    //let width = 1_000_000;
    //let height = 1_000_000;
    let boundary = new Rectangle(width/2, height/2, width/2, height/2);
    quadTree = new QuadTree(boundary, 4);
    
    for(let job of jobs) {
        let p = new Point(job[0], job[1]);
        quadTree.insert(p);
    }
    
    let out = 0
    jobs.map(job=>{
        let range = new Rectangle(job[0], job[1], wageOffset, hourlyOffset);
        let foundJobs = quadTree.countInRange(range);
        out += foundJobs;
    });
    
    console.timeEnd("relativeJobs");
    return out;
}

relativeJobsHard2 = (a, w, h) =>{
    console.time("relativeJobsHard");
    a.sort((x,y)=>x[0]-y[0])
    n=l=a.length
    for(i=0;i<l;i++){
        [p,q]=a[i];
        for(j=i+1;j<l&& a[j][0]<=p+w;j++){
            [x,y]=a[j];
            n+=2* (p-w<=x&&y<=q+h && q-h<=y)  
        }
    } 
    console.timeEnd("relativeJobsHard");
    return n   
}