function d3Draw(dataset){


Width=300;
Height=200;
var svg= d3.select("body").append("svg")
   .attr("width",Width)
   .attr("Height",Height);
   
var circles=svg.selectAll("circle")
   .data(dataset)
   .enter()
   .append("circle");

circles.attr("cx", function(d){
    return d.x;
} )
.attr("cy",function(d){
    return d.y;
} )
.attr("r", 5);  
   
}

function loadData(){
   d3.csv("data1.txt",function(error,data){
   if (error){
      console.log("That file doesn't exist")
      console.log(error)
   }else{
      d3Draw(data);
      }
}
);
}
 

window.onload= loadData;