var exec = require('cordova/exec');

var transporter = {}


// method to test whether the plugin has installed successfully or not
transporter.testMethod = function(message,success,error){
  exec(success,error,"transporter","testMethod",[message]);
}

// method to pass the secret key to the transporter server to identify the user
transporter.initialize = function(secretKey,success,error){
  exec(success,error,"transporter","initialize",[secretKey]);
}

//Method to set userId which helps to identify different bikers of the same user 
transporter.setUserId = function(userId,success,error){
  exec(success,error,"transporter","setUserId",[userId]);
}

//Method to set Description/Name of the biker
transporter.setDescription = function(description,success,error){
  exec(success,error,"transporter","setDescription",[description]);
}

//Method to start Tracking
transporter.startTracking = function(success, error) {
  exec(success, error, "transporter", "startTracking", [])
};

//Method to stop Tracking
transporter.stopTracking = function(success, error) {
  exec(success, error, "transporter", "stopTracking", [])
};

//Method to check Location Settings, returns true if the gps location service is on else false
transporter.isLocationEnabled = function(success, error){
  exec(success,error, "transporter", "isLocationEnabled", [])
};

//Method to request Location Settings if gps location service is off
transporter.requestLocationSettings = function(success, error){
  exec(success,error, "transporter", "requestLocationSettings", [])
};

//Method to check Self Permissions main location permission
//Must be used with android versions less than 23
//returns true if the permissions to use the location service is given else false 
transporter.checkSelfPermissions = function(success, error){
  exec(success,error, "transporter", "checkSelfPermissions", [])
};

//Method to request Self location Permissions when checkSelfPermissions returns false
transporter.requestPermissions = function(success, error){
  exec(success,error, "transporter", "requestPermissions", [])
};

module.exports = transporter;
