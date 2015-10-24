var DeviceState = function() {

};

DeviceState.prototype.start = function(successFn, failFn) {
  cordova.exec(successFn, failFn, 'DeviceState', 'start', []);
};

DeviceState.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.devicestate = new DeviceState();
  return window.plugins.devicestate;
}

cordova.addConstructor(DeviceState.install);
