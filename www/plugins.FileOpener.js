var exec = require("cordova/exec");

function FileOpener() {};

FileOpener.prototype.open = function(fileName, contentType) {
	exec(null, null, "FileOpener", "open", [fileName, contentType]);
};

var fileOpener = new FileOpener();
module.exports = fileOpener;
