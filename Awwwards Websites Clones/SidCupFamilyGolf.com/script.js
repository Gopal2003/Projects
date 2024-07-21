/* This code snippet is using the GSAP (GreenSock Animation Platform) library to animate the element
with the id "nav". Here's a breakdown of what it's doing: */

var cursor = document.querySelector("#cursor");
var cursorBlur = document.querySelector("#cursor-blur");
document.addEventListener("mousemove",function(dets){
    cursor.style.top = dets.y-8 + "px";
    cursor.style.left = dets.x-10 + "px";
    cursorBlur.style.top = dets.y - 200 + "px";
    cursorBlur.style.left = dets.x - 200 + "px";

})


gsap.to("#nav",{
    backgroundColor: "#000",
    height: "120px",
    duration: 0.5,
    scrollTrigger: {
        trigger:"#nav",
        scroller:"body",
        // markers:true,
        start: "top -10%",
        end: "top -20%",
        scrub: 0.9
    }
})


gsap.to("#main",{
    backgroundColor : "#000",
    scrollTrigger: {
        trigger : "#main",
        scroller: "body",
        // markers: true,
        start: "top -25%",
        end: "top -70%",
        scrub: 0.9
    }
})

var h4all = document.querySelectorAll("#nav h4");

h4all.forEach(function(elem){
        elem.addEventListener("mouseenter",function(){
            cursor.style.scale = "3";
            cursor.style.border = "1px solid #fff";
            cursor.style.backgroundColor = "transparent";
            elem.style.color = "greenyellow";
            cursor.style.transition = "color 0.7s linear";
        })

        elem.addEventListener("mouseleave",function(){
            cursor.style.scale = "1";
            cursor.style.border = "1px solid #95c11e";
            cursor.style.backgroundColor = "#95c11e";
            elem.style.color = "white";
            cursor.style.transition = "none";
            cursor.style.zindex = "100";
            
        })
})

gsap.from("#about-us img,#about-us-in",{
    y:90,
    opacity:0,
    duration:1,
    // stagger:0.4,
    scrollTrigger: {
        trigger: "#about-us",
        scroller: "body",
        start: "top 60%",
        end: "top 55%",
        scrub: 0.9
    }
})

gsap.from(".card",{
    scale:0.9,
    // opacity:0,
    duration:0.1,
    // stagger:0.4,
    scrollTrigger: {
        trigger: ".card",
        scroller: "body",
        start: "top 70%",
        end: "top 65%",
        scrub: 0.1
    }
})

gsap.from("#colon1",{
    y: -70,
    x: -70,
    scrollTrigger:{
        trigger: "#colon1",
        scroller: "body",
        start: "top 45%",
        end: "top 35%",
        scrub: 4
    }
})

gsap.from("#colon2",{
    y: 70,
    x: 70,
    scrollTrigger:{
        trigger: "#colon1",
        scroller: "body",
        start: "top 45%",
        end: "top 35%",
        scrub: 4
    }
})

gsap.from("#page4 h1",{
    y: 70,
    scrollTrigger:{
        trigger: "#page4 h1",
        scroller: "body",
        start: "top 95%",
        end: "top 80%",
        // markers:true,
        scrub: 2
    }
})