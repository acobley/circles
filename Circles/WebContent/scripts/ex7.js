function d3Draw() {
	var dataset = [ 5, 10, 15, 20, 25, 30 ];
	Width = 300;
	Height = 200;
	var svg = d3.select("body").append("svg").attr("width", Width).attr(
			"Height", Height);

}
window.onload = d3Draw;