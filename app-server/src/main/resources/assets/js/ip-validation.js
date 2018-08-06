/**
* JavaScript wrapper for Information Package validation
*/
var ipValidator = {
  result : null,
  status : null,
  validate : function (formData, callback, contentType = 'json') {
    $.ajax({
      url         : 'api/validate',
      type        : 'POST',
      data        : formData,
      dataType    : contentType,
      contentType : false,
      processData : false,
      success     : function (data, textStatus, jqXHR) {
        ipValidator.result = jqXHR.responseText;
        callback();
      },
      // Log call errors to the console
      error       : function (jqXHR, textStatus, errorThrown) {
        console.log('Validation Error: ' + textStatus + errorThrown);
        console.log(jqXHR);
      }
    });
  }
};
