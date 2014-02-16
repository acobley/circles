function d3Draw(){
var dataset=[5,10,15,20,25,30];

d3.select("body").selectAll("p")
   .data(dataset)
   .enter()
   .append("p")
   .text(function(d){
      return "new Paragraph" + d;
      });
   }

window.onload= d3Draw;