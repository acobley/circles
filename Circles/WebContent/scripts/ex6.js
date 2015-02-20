function d3Draw() {
	var dataset = [ 5, 10, 15, 20, 25, 30, 35, 60, 70 ];

	d3.select("body").selectAll("div").data(dataset).enter().append("div")
			.attr("class", "bar").style("height", function(d) {
				return 2 * d + "px";
			}).style("background-color", function(d) {
				return "#" + 2 * d + 2 * d + 2 * d;
			});
}

window.onload = d3Draw;