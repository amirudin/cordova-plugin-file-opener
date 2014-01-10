var exec = require("cordova/exec");

function FileOpener() {};

FileOpener.prototype.open = function(fileName, contentType, callbackContext) {
	callbackContext = callbackContext || {};
	exec(callbackContext.success || null, callbackContext.error || null, "FileOpener", "open", [fileName, contentType]);
};

var fileOpener = new FileOpener();
module.exports = fileOpener;
