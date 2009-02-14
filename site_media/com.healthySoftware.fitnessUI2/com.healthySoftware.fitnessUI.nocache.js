function com_healthySoftware_fitnessUI(){
  var $wnd_0 = window, $doc_0 = document, $stats = $wnd_0.__gwtStatsEvent?function(a){
    return $wnd_0.__gwtStatsEvent(a);
  }
  :null, scriptsDone, loadDone, bodyDone, base = '', metaProps = {}, values = [], providers = [], answers = [], onLoadErrorFunc, propertyErrorFunc;
  $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'bootstrap', millis:(new Date()).getTime(), type:'begin'});
  if (!$wnd_0.__gwt_stylesLoaded) {
    $wnd_0.__gwt_stylesLoaded = {};
  }
  if (!$wnd_0.__gwt_scriptsLoaded) {
    $wnd_0.__gwt_scriptsLoaded = {};
  }
  function isHostedMode(){
    try {
      return $wnd_0.external && ($wnd_0.external.gwtOnLoad && $wnd_0.location.search.indexOf('gwt.hybrid') == -1);
    }
     catch (e) {
      return false;
    }
  }

  function maybeStartModule(){
    if (scriptsDone && loadDone) {
      var iframe = $doc_0.getElementById('com.healthySoftware.fitnessUI');
      var frameWnd = iframe.contentWindow;
      frameWnd.__gwt_initHandlers = com_healthySoftware_fitnessUI.__gwt_initHandlers;
      if (isHostedMode()) {
        frameWnd.__gwt_getProperty = function(name){
          return computePropValue(name);
        }
        ;
      }
      com_healthySoftware_fitnessUI = null;
      frameWnd.gwtOnLoad(onLoadErrorFunc, 'com.healthySoftware.fitnessUI', base);
      $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date()).getTime(), type:'end'});
    }
  }

  function computeScriptBase(){
    var thisScript, markerId = '__gwt_marker_com.healthySoftware.fitnessUI', markerScript;
    $doc_0.write('<script id="' + markerId + '"><\/script>');
    markerScript = $doc_0.getElementById(markerId);
    thisScript = markerScript && markerScript.previousSibling;
    while (thisScript && thisScript.tagName != 'SCRIPT') {
      thisScript = thisScript.previousSibling;
    }
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf('#');
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf('?');
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf('/', Math.min(queryIndex, hashIndex));
      return slashIndex >= 0?path.substring(0, slashIndex + 1):'';
    }

    ;
    if (thisScript && thisScript.src) {
      base = getDirectoryOfFile(thisScript.src);
    }
    if (base == '') {
      var baseElements = $doc_0.getElementsByTagName('base');
      if (baseElements.length > 0) {
        base = baseElements[baseElements.length - 1].href;
      }
       else {
        base = getDirectoryOfFile($doc_0.location.href);
      }
    }
     else if (base.match(/^\w+:\/\//)) {
    }
     else {
      var img = $doc_0.createElement('img');
      img.src = base + 'clear.cache.gif';
      base = getDirectoryOfFile(img.src);
    }
    if (markerScript) {
      markerScript.parentNode.removeChild(markerScript);
    }
  }

  function processMetas(){
    var metas = document.getElementsByTagName('meta');
    for (var i = 0, n = metas.length; i < n; ++i) {
      var meta = metas[i], name = meta.getAttribute('name'), content;
      if (name) {
        if (name == 'gwt:property') {
          content = meta.getAttribute('content');
          if (content) {
            var value, eq = content.indexOf('=');
            if (eq >= 0) {
              name = content.substring(0, eq);
              value = content.substring(eq + 1);
            }
             else {
              name = content;
              value = '';
            }
            metaProps[name] = value;
          }
        }
         else if (name == 'gwt:onPropertyErrorFn') {
          content = meta.getAttribute('content');
          if (content) {
            try {
              propertyErrorFunc = eval(content);
            }
             catch (e) {
              alert('Bad handler "' + content + '" for "gwt:onPropertyErrorFn"');
            }
          }
        }
         else if (name == 'gwt:onLoadErrorFn') {
          content = meta.getAttribute('content');
          if (content) {
            try {
              onLoadErrorFunc = eval(content);
            }
             catch (e) {
              alert('Bad handler "' + content + '" for "gwt:onLoadErrorFn"');
            }
          }
        }
      }
    }
  }

  function unflattenKeylistIntoAnswers(propValArray, value){
    var answer = answers;
    for (var i = 0, n = propValArray.length - 1; i < n; ++i) {
      answer = answer[propValArray[i]] || (answer[propValArray[i]] = []);
    }
    answer[propValArray[n]] = value;
  }

  function computePropValue(propName){
    var value = providers[propName](), allowedValuesMap = values[propName];
    if (value in allowedValuesMap) {
      return value;
    }
    var allowedValuesList = [];
    for (var k in allowedValuesMap) {
      allowedValuesList[allowedValuesMap[k]] = k;
    }
    if (propertyErrorFunc) {
      propertyErrorFunc(propName, allowedValuesList, value);
    }
    throw null;
  }

  var frameInjected;
  function maybeInjectFrame(){
    if (!frameInjected) {
      frameInjected = true;
      var iframe = $doc_0.createElement('iframe');
      iframe.src = "javascript:''";
      iframe.id = 'com.healthySoftware.fitnessUI';
      iframe.style.cssText = 'position:absolute;width:0;height:0;border:none';
      iframe.tabIndex = -1;
      $doc_0.body.appendChild(iframe);
      $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date()).getTime(), type:'moduleRequested'});
      iframe.contentWindow.location.replace(base + strongName);
    }
  }

  providers['user.agent'] = function(){
    var ua = navigator.userAgent.toLowerCase();
    var makeVersion = function(result){
      return parseInt(result[1]) * 1000 + parseInt(result[2]);
    }
    ;
    if (ua.indexOf('opera') != -1) {
      return 'opera';
    }
     else if (ua.indexOf('webkit') != -1) {
      return 'safari';
    }
     else if (ua.indexOf('msie') != -1) {
      var result_0 = /msie ([0-9]+)\.([0-9]+)/.exec(ua);
      if (result_0 && result_0.length == 3) {
        if (makeVersion(result_0) >= 6000) {
          return 'ie6';
        }
      }
    }
     else if (ua.indexOf('gecko') != -1) {
      var result_0 = /rv:([0-9]+)\.([0-9]+)/.exec(ua);
      if (result_0 && result_0.length == 3) {
        if (makeVersion(result_0) >= 1008)
          return 'gecko1_8';
      }
      return 'gecko';
    }
    return 'unknown';
  }
  ;
  values['user.agent'] = {gecko:0, gecko1_8:1, ie6:2, opera:3, safari:4};
  com_healthySoftware_fitnessUI.onScriptLoad = function(){
    if (frameInjected) {
      loadDone = true;
      maybeStartModule();
    }
  }
  ;
  com_healthySoftware_fitnessUI.onInjectionDone = function(){
    scriptsDone = true;
    $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'loadExternalRefs', millis:(new Date()).getTime(), type:'end'});
    maybeStartModule();
  }
  ;
  computeScriptBase();
  processMetas();
  $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'bootstrap', millis:(new Date()).getTime(), type:'selectingPermutation'});
  var strongName;
  if (isHostedMode()) {
    strongName = 'hosted.html?com_healthySoftware_fitnessUI';
  }
   else {
    try {
      unflattenKeylistIntoAnswers(['opera'], '79CF53723AAE21A53AEB4535925404CC.cache.html');
      unflattenKeylistIntoAnswers(['ie6'], '9E6186F437370A1BD8ABDF48ADEC4378.cache.html');
      unflattenKeylistIntoAnswers(['gecko1_8'], 'CDD9FE38170CA6C26C98B957619AD80F.cache.html');
      unflattenKeylistIntoAnswers(['gecko'], '26F974101C6BD3C77A101D97C8D0DF68.cache.html');
      unflattenKeylistIntoAnswers(['safari'], '44C04654E1190C2013055305C1944EAF.cache.html');
      strongName = answers[computePropValue('user.agent')];
    }
     catch (e) {
      return;
    }
  }
  var onBodyDoneTimerId;
  function onBodyDone(){
    if (!bodyDone) {
      bodyDone = true;
      if (!__gwt_stylesLoaded['gwt/standard/standard.css']) {
        var l = $doc_0.createElement('link');
        __gwt_stylesLoaded['gwt/standard/standard.css'] = l;
        l.setAttribute('rel', 'stylesheet');
        l.setAttribute('href', base + 'gwt/standard/standard.css');
        $doc_0.getElementsByTagName('head')[0].appendChild(l);
      }
      if (!__gwt_stylesLoaded['fitnessUI.css']) {
        var l = $doc_0.createElement('link');
        __gwt_stylesLoaded['fitnessUI.css'] = l;
        l.setAttribute('rel', 'stylesheet');
        l.setAttribute('href', base + 'fitnessUI.css');
        $doc_0.getElementsByTagName('head')[0].appendChild(l);
      }
      maybeStartModule();
      if ($doc_0.removeEventListener) {
        $doc_0.removeEventListener('DOMContentLoaded', onBodyDone, false);
      }
      if (onBodyDoneTimerId) {
        clearInterval(onBodyDoneTimerId);
      }
    }
  }

  if ($doc_0.addEventListener) {
    $doc_0.addEventListener('DOMContentLoaded', function(){
      maybeInjectFrame();
      onBodyDone();
    }
    , false);
  }
  var onBodyDoneTimerId = setInterval(function(){
    if (/loaded|complete/.test($doc_0.readyState)) {
      maybeInjectFrame();
      onBodyDone();
    }
  }
  , 50);
  $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'bootstrap', millis:(new Date()).getTime(), type:'end'});
  $stats && $stats({moduleName:'com.healthySoftware.fitnessUI', subSystem:'startup', evtGroup:'loadExternalRefs', millis:(new Date()).getTime(), type:'begin'});
  $doc_0.write('<script defer="defer">com_healthySoftware_fitnessUI.onInjectionDone(\'com.healthySoftware.fitnessUI\')<\/script>');
}

com_healthySoftware_fitnessUI.__gwt_initHandlers = function(resize, beforeunload, unload){
  var $wnd_0 = window, oldOnResize = $wnd_0.onresize, oldOnBeforeUnload = $wnd_0.onbeforeunload, oldOnUnload = $wnd_0.onunload;
  $wnd_0.onresize = function(evt){
    try {
      resize();
    }
     finally {
      oldOnResize && oldOnResize(evt);
    }
  }
  ;
  $wnd_0.onbeforeunload = function(evt){
    var ret, oldRet;
    try {
      ret = beforeunload();
    }
     finally {
      oldRet = oldOnBeforeUnload && oldOnBeforeUnload(evt);
    }
    if (ret != null) {
      return ret;
    }
    if (oldRet != null) {
      return oldRet;
    }
  }
  ;
  $wnd_0.onunload = function(evt){
    try {
      unload();
    }
     finally {
      oldOnUnload && oldOnUnload(evt);
      $wnd_0.onresize = null;
      $wnd_0.onbeforeunload = null;
      $wnd_0.onunload = null;
    }
  }
  ;
}
;
com_healthySoftware_fitnessUI();
