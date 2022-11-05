/**
 *
 */

function d3Draw(dataset){
Width=300;
Height=200;
if ((typeof svg == 'undefined') ){
   var svg= d3.select("body").append("svg")
   .attr("width",Width)
   .attr("Height",Height);
}
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
.attr("r", function(d){
    return d.r;
} );

}

function loadData(){


	d3.select("p")
	.on("click",function(){

		loadData();
	});
   d3.json("http://35.241.142.116/Circles/Circles/10",function(error,data){
   if (error){
      console.log(error)
   }else{
      d3Draw(data);
      }
   }
   );
}



window.onload= loadData;
