function d3Draw(){
var dataset=[5,10,15,20,25,30];
d3.select("body").append("p").text("new para");
d3.select("body").append("H1").text("new heading");
d3.select("body").selectAll("p")
   .data(dataset)
   .enter()
   .append("p")
   .text("new para");
   }

window.onload= d3Draw;