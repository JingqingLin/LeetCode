// ==UserScript==
// @name         Github代码块字体自定义
// @namespace    http://tampermonkey.net/
// @version      0.1
// @author       JingqingLin
// @match        https://*.github.com/*
// @include       https://*.github.com/*
// @run-at        document-start
// @grant        none
// ==/UserScript==

(function() {
    'use strict';
    var css = [
        ".blob-code-inner {",
        "font-family: Cascadia Code !important;",
        "font-size: 14px !important;",
        "}",
        ".CodeMirror-lines {",
        "font-family: Cascadia Code !important;",
        "font-size: 14px !important;",
        "}",
].join("\n");
if (typeof GM_addStyle != "undefined") {
	GM_addStyle(css);
} else if (typeof PRO_addStyle != "undefined") {
	PRO_addStyle(css);
} else if (typeof addStyle != "undefined") {
	addStyle(css);
} else {
	var node = document.createElement("style");
	node.type = "text/css";
	node.appendChild(document.createTextNode(css));
	var heads = document.getElementsByTagName("head");
	if (heads.length > 0) {
		heads[0].appendChild(node);
	} else {
		// no head yet, stick it whereever
		document.documentElement.appendChild(node);
	}
}
})();
