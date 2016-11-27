var buttons = document.querySelectorAll(".radmenu a");

for (var i=0, l=buttons.length; i<l; i++) {
  var button = buttons[i];
  button.onclick = setSelected;
}

function setSelected(e) {

    if (this.classList.contains("selected")) {
      this.classList.remove("selected");
      if (!this.parentNode.classList.contains("radmenu")) {
        this.parentNode.parentNode.parentNode.querySelector("a").classList.add("selected")
      } else {
        this.classList.add("show");
      }
    } else {
        if (!this.classList.contains("choice"))
            this.classList.add("selected");

      if (!this.parentNode.classList.contains("radmenu")) {
        this.parentNode.parentNode.parentNode.querySelector("a").classList.remove("selected")
      } else {
        this.classList.remove("show");
      }
    }
    return false;
}

var test = document.getElementById("aa");

test.onmousemove = function moveimg(e) {document.body.style.background="url(js/test.jpeg)";};
test.onmouseout = function moveimg(e) {document.body.style.background="url(js/test1.jpeg)";};

