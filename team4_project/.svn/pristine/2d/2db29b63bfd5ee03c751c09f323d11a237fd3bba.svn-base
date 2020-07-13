(function($){
  
  var $fileBox = null;
  
  $(function() {
    init();
  })
  
  function init() {
    $fileBox = $('.input-file');
    fileLoad();
  }
  
  function fileLoad() {
    $.each($fileBox, function(idx){
      var $this = $fileBox.eq(idx),
          $btnUpload = $this.find('[type="file"]'),
          $label = $this.find('.file-label');
      
      $btnUpload.on('change', function() {
        var $target = $(this),
        	num = $target.val().lastIndexOf("\\"),
            fileName = $target.val().substr(num+1),
            $fileText = $target.siblings('.file-name');
        $fileText.val(fileName);
      })
      
      $btnUpload.on('focusin focusout', function(e) {
        e.type == 'focusin' ?
          $label.addClass('file-focus') : $label.removeClass('file-focus');
      })
      
    })
  }
  
  function fileLoad() {
	    $.each($fileBox, function(idx){
	      var $this = $fileBox.eq(idx),
	          $btnUpload = $this.find('[type="file"]'),
	          $label = $this.find('.file-label');
	      
	      $btnUpload.on('change', function() {
	        var $target = $(this),
	        	num = $target.val().lastIndexOf("\\"),
	            fileName = $target.val().substr(num+1),
	            $fileText = $target.siblings('.file-name');
	        $fileText.val(fileName);
	      })
	      
	      $btnUpload.on('focusin focusout', function(e) {
	        e.type == 'focusin' ?
	          $label.addClass('file-focus') : $label.removeClass('file-focus');
	      })
	      
	    })
	  }
  
  
})(jQuery);

function fn_Download(filePath,fileName){



	$("#frmPopFiledown").find("#filePath").val(filePath);

	$("#frmPopFiledown").find("#fileName").val(fileName);

	document.frmPopFiledown.action = "/downloadFiles.json";

	document.frmPopFiledown.submit();

}
