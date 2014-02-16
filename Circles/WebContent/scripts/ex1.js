var dataset=[5,10,15,20,25,30];
d3.select("body").selectAll("p")
   .data(datset)
   .enter()
   .append("p")
   .text("new para");