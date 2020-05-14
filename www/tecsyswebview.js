var exec = require('cordova/exec');

module.exports = {

    init: function (success, error) {
        exec(success, error, 'TecsysWebview', 'init', []);
    },
    
    test: function (success, error) {
        exec(success, error, 'TecsysWebview', 'test', []);
    }
}
