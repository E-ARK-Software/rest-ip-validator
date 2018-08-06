/**
* Document ready function, loaded up on start
*/
$(document).ready( function() {
  /**
  * Event handler for the file selector
  */
  $('input:file').on('change', function() {
    // Disable the submit button
    $('button').prop('disabled', true);
    // Grab the label component
    var fileLabel = $(this).siblings('.custom-file-label');
    // Get filename without the fake path prefix
    var fileName = $(this).val().split('\\').pop();
    // Set the filename selection, a little tricksy
    fileLabel.addClass("selected").html(fileName);
    // Calculate and display the SHA1 of the file
    calcFileSha1(this.files[0]);
  });

  /**
  * Event handler for submit button
  */
  $('button').click(function () {
    // Grab the data from the form object
    var formData = new FormData($('form')[0])
    // Call the validator, with result renderer as callback
    ipValidator.validate(formData, function() {
      renderResult();
    });
  });
});

/**
* Calculates the SHA-1 of selected file and displays the result
*/
function calcFileSha1(file) {
  // New checksum calculator instance
  rusha = new Rusha();
  // File reader to get data
  reader = new FileReader();
  // Register reader onload event
  reader.onload = function(e) {
    // Calculate the checksum from the reader result
    var digest = rusha.digest(reader.result);
    // Set the label when finished
    $("#digest").val(digest);
    // Enable the submit button
    $('button').prop('disabled', false);
  }
  // Signal checkcum calculation and load reader
  $("#digest").val("Calcluating package checksum...");
  reader.readAsBinaryString(file);
}

/**
* Render the validation result to screen
*/
function renderResult() {
  $("#results").empty();
  var preBlock = $("<pre>").text(ipValidator.result);
  $("#results").append(preBlock);
}
