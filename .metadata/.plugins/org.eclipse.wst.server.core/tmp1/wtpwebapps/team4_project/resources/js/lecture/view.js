/* 버튼 */
var video = document.getElementById("video");
var play = document.getElementById("play");
var pause = document.getElementById("pause");
var stop = document.getElementById("stop");
var timeCurrent = document.getElementById("currentTime");
var timeTotal = document.getElementById("totalTime");
var mute = document.getElementById("mute");
var unmute = document.getElementById("unmute");
var vmup = document.getElementById("vmup");
var vmdown = document.getElementById("vmdown");
var full = document.getElementById("full");
var progress = document.getElementById("progress");
var progressBar = document.getElementById("progressBar");

/*video.volume = 1;*/

/**
플레이어 함수 
**/

//재생일시정지함수
function playPause () {
    if (video.paused) {
        video.play();
        play.style.display = "none";
        pause.style.display = "inline-block";
    } else {
        video.pause();
        play.style.display = "inline-block";
        pause.style.display = "none";
    }
}

//정지함수
function stopPlayer () {
    video.pause();
    video.currentTime = 0;
}

//음소거토글함수
function mutePlayer (state) {
    if (state == "mute") {
        video.volume = 0;
        mute.style.display = "none";
        unmute.style.display = "inline-block";
    } else if (state == "unmute") {
        video.volume = 1;
        mute.style.display = "inline-block";
        unmute.style.display = "none";
    }
}

//볼륨updown
function volumeUpDown (dir) {
    if (dir == "up") {
        if (video.volume == 1) {
            return false;
        }
        var change = video.volume + 0.1;
        change = change.toFixed(1);
        video.volume = parseFloat(change);
        //console.log(video.volume);
    } else if (dir =="down") {
        if (video.volume == 0) {
            mute.style.display = "none";
            unmute.style.display = "inline-block";
            return false;
        }
        var change = video.volume - 0.1;
        change = change.toFixed(1);
        video.volume = parseFloat(change);
        //console.log(video.volume);
    }
}

//전체화면
function fullScreen () {
    if (video.requestFullscreen) {
        video.requestFullscreen();
    } else if (video.mozRequestFullScreen) {
        video.mozRequestFullScreen();
    } else if (video.webkitRequestFullscreen) {
        video.webkitRequestFullscreen();
    } else if (video.msRequestFullscreen) {
        video.msRequestFullscreen();
    }
}

//재생시간함수
function playTime () {
    //총재생시간
    video.addEventListener("durationchange", function () {
        var duration = video.duration;
        var durationmin = Math.floor(duration / 60);
        var durationsec = Math.floor(duration - (durationmin * 60));
        if (durationmin < 10) {
            durationmin = "0" + durationmin;
        }
        if (durationsec < 10) {
            durationsec = "0" + durationsec;
        }
        var durationTotal = durationmin + ":" + durationsec;
        timeCurrent.innerHTML = durationTotal;
    });
    //현재재생시간
    video.addEventListener("timeupdate", function () {
        if (video.duration == video.currentTime) {
            play.style.display = "inline-block";
            pause.style.display = "none";
        }
        var current = video.currentTime;
        var currentmin = Math.floor(current / 60);
        var currentsec = Math.floor(current - (currentmin * 60));
        if (currentmin < 10) {
            currentmin = "0" + currentmin;
        }
        if (currentsec < 10) {
            currentsec = "0" + currentsec;
        }
        var currentTotal = currentmin + ":" + currentsec;
        timeTotal.innerHTML = currentTotal;
    });
} 

//프로그레스바
function progressPlayer () {
    video.addEventListener("timeupdate", function () {
        var max = Math.floor(video.duration);
        var current = Math.floor(video.currentTime);
        var percent = 100 * (current / max);
        progressBar.style.width = percent + "%";
    });
}

//프로그레스바 seek
function seek (event) {
    var seekTotal = parseInt(progress.style.width);
    var seekX = event.offsetX;
    var seekPercent = 100 * (seekX / seekTotal); 
    progressBar.style.width = seekPercent + "%";
    var seekMove = (seekPercent / 100) * Math.floor(video.duration);
    video.currentTime = seekMove;
}

/* 함수실행 */
playTime();
progressPlayer();

/* 파이어폭스 이벤트 크로스브라우징코드 */
if (navigator.userAgent.indexOf("Firefox") >= 0) {
    var eventNames = ["mousedown", "mouseover", "mouseout", "mousemove", "mousedrag", "click", "dbclick", "keydown", "keypress", "keyup"];
    for (var i = 0; i <eventNames.length; i++) {
        window.addEventListener(eventNames[i], function (e) {
            window.event = e;
        }, true);
    }
}

/* 이벤트 */
play.addEventListener("click", function () {
    playPause();
});//재생

pause.addEventListener("click", function () {
    playPause();
});//일시정지

stop.addEventListener("click", function () {
    stopPlayer();
});//정지

mute.addEventListener("click", function () {
    mutePlayer("mute")
});//음소거

unmute.addEventListener("click", function () {
    mutePlayer("unmute")
})//볼륨있음

vmup.addEventListener("click", function () {
    volumeUpDown("up");
});//볼륨업

vmdown.addEventListener("click", function () {
    volumeUpDown("down");
});//볼륨다운

full.addEventListener("click", function () {
    fullScreen();
});//풀스크린

progress.addEventListener("click", function () {
    seek(event);
});//seek
