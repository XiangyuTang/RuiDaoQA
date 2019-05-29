
try {
  var SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
  var recognition = new SpeechRecognition();
}
catch(e) {
  console.error(e);
  $('.no-browser-support').attr('style','display: block');;
  alert("想不到吧，调用不了API");
}


var noteTextarea = $('#L_content');
var instructions = $('#recording-instructions');

var noteContent = '';

/*-----------------------------
      语音识别 
------------------------------*/

recognition.continuous = true;//使用户在录入语音时能有更长的停顿时间，大约15秒

recognition.onresult = function(event) {

  // event 是一个SpeechRecognitionEvent 对象
  // 保存了所有历史捕获对象 
  // 我们只取当前的内容
  var current = event.resultIndex;

  // 获取此前所说话的记录
  var transcript = event.results[current][0].transcript;

  // 将当前记录添加到笔记内容中
  // 解决安卓设备的bug
  var mobileRepeatBug = (current == 1 && transcript == event.results[0][0].transcript);

  if(!mobileRepeatBug) {
  	
    noteContent += transcript;
    noteTextarea.val(noteContent);
    layedit.sync(index);//将富文本编辑器的内容同步到textarea
  }
};

recognition.onstart = function() { 
  instructions.text('语音识别功能激活！请对着麦克风讲话。');
}

recognition.onspeechend = function() {
  instructions.text('长时间未说话，已自动关闭录音。');
}

recognition.onerror = function(event) {
  if(event.error == 'no-speech') {
    instructions.text('未检测到语音，请再试一次。');  
  };
}

/*-----------------------------
      应用功能按钮与输入 
------------------------------*/

$('#start-record-btn').on('click', function(e) {
  if (noteContent.length) {
    noteContent += ' ';
  }
  recognition.start();
});


$('#pause-record-btn').on('click', function(e) {
  recognition.stop();
  instructions.text('语音识别暂停。');
});

// 同步文本框文本与noteContent变量
noteTextarea.on('input', function() {
  noteContent = $(this).val();
  layedit.sync(index);//将富文本编辑器的内容同步到textarea
})



/*-----------------------------
      语音合成 
------------------------------*/

function readOutLoud(message) {
	var speech = new SpeechSynthesisUtterance();

  // 设置朗读内容和属性
	speech.text = message;
	speech.volume = 1;
	speech.rate = 1;
	speech.pitch = 1;
  
	window.speechSynthesis.speak(speech);
}
