var viz = new Viz();

function renderDot(target, source) {
    viz.renderSVGElement(source)
        .then(function (element) {
            document.getElementById(target).innerHTML = "";
            document.getElementById(target).appendChild(element);
            svgPanZoom(element, {
                controlIconsEnabled: false,
                minZoom: 0.1
            });
        })
        .catch(error => {
            viz = new Viz();
            console.error(error);
        })
}
