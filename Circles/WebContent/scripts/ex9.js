function d3Draw(){
var dataset=[ [5,20], [10,35],  [34,10], [40,60] ]
;
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
    return d[0];
} )
.attr("cy",function(d){
    return d[1];
} )
.attr("r", 5);  
   
}
window.onload= d3Draw;