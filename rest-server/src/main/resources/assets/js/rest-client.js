$(document).ready( function() {
  console.log("ready");
  $('input:file').on('change', function() {
    var fileLabel = $(this).siblings('.custom-file-label');
    var files = this.files;
    var log = 'File selected: ' + $(this).val().split('\\').pop();
    console.log(log);
    fileLabel.val($(this).val());
    $("#digest").val(digest);
  });
});
