/**
 * 
 */
var svg;
function d3Draw(dataset) {
	Width = 300;
	Height = 200;
	if ((typeof svg == 'undefined')) {
		svg = d3.select("body").append("svg").attr("width", Width).attr(
				"Height", Height);
	} else {
		/*
		 * d3.select("svg").remove(); svg= d3.select("body").append("svg")
		 * .attr("width",Width) .attr("Height",Height);
		 */
	}
	var circles = svg.selectAll("circle").data(dataset).enter()
			.append("circle");

	circles.attr("cx", function(d) {
		return d.x;
	}).attr("cy", function(d) {
		return d.y;
	}).attr("r", function(d) {
		return d.r;
	});

}

function d3Update(dataset) {

	var circles = svg.selectAll("circle").data(dataset);

	circles.attr("cx", function(d) {
		return d.x;
	}).attr("cy", function(d) {
		return d.y;
	}).attr("r", function(d) {
		return d.r;
	});

}

function loadData() {

	d3.select("p").on("click", function() {

		updateData();
	});
	d3.json("http://35.233.33.123/Circles/Circles/10", function(
			error, data) {
		if (error) {
			console.log(error)
		} else {
			d3Draw(data);
		}
	});
}

function updateData() {

	d3.json("http://35.233.33.123/Circles/Circles/10", function(
			error, data) {
		if (error) {
			console.log(error)
		} else {
			d3Update(data);
		}
	});
}

window.onload = loadData;
