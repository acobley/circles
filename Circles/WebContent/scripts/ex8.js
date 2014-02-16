function d3Draw(){
var dataset=[5,10,15,20,25,30];
Width=300;
Height=200;
var svg= d3.select("body").append("svg")
   .attr("width",Width)
   .attr("Height",Height);
   
var circles=svg.selectAll("circle")
   .data(dataset)
   .enter()
   .append("circle");

circles.attr("cx", function(d,i){
    return(i*50)+25;
} )
.attr("cy",Height/2)
.attr("r", function(d){
    return d;
});  
   
}
window.onload= d3Draw;