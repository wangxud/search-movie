//<img src="http://thecodeplayer.com/u/uifaces/'+i+'.jpg" />
var images = "", count = 50;
for(var i = 1; i <= count; i++)
	images += '<img src="pic/'+i+'.jpg" />';

$(".grid").append(images);

var d = 0; //delay
var ry, tz, s; //transform params

//animation time
$(window).on("load",reload);
function reload(){
	$("img").each(function(){
		d = Math.random()*1000; //1ms to 1000ms delay
		$(this).delay(d).animate({opacity: 0}, {
			step: function(n){
				s = 1-n; //scale - will animate from 0 to 1
				$(this).css("transform", "scale("+s+")");
			},
			duration: 1000,
		})
	}).promise().done(function(){
		storm();
	})
}

function storm()
{
	$("img").each(function(){
		d = Math.random()*1000;
		$(this).delay(d).animate({opacity: 1}, {
			step: function(n){
				ry = (1-n)*360;
				tz = (1-n)*1000;
				//$(this).css("transform", "rotateY("+ry+"deg) translateZ("+tz+"px)");
			},
			duration: 3000,
			easing: 'easeOutQuint',
		})
	})
}




