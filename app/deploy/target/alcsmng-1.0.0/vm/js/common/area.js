function initComplexArea(a, k, h, p, q,sub_arr, d, b, l) {
	var f = initComplexArea.arguments;
	var m = document.getElementById(a);
	var o = document.getElementById(k);
	var n = document.getElementById(h);
	var e = 0;
	var c = 0;
	if (p != undefined) {
		if (d != undefined) {
			d = parseInt(d);
		} else {
			d = 0;
		}
		if (b != undefined) {
			b = parseInt(b);
		} else {
			b = 0;
		}
		if (l != undefined) {
			l = parseInt(l);
		} else {
			l = 0;
		}
		
		n[0] = new Option("��ѡ�� ", 0);
		for (e = 0; e < p.length; e++) {
			if (p[e] == undefined) {
				continue;
			}
			if (f[7]) {
				if (f[7] == true) {
					if (e == 0) {
						continue;
					}
				}
			}
			m[c] = new Option(p[e], e);
			if (d == e) {
				m[c].selected = true;
			}
			c++;
		}
		
		o[0] = new Option("��ѡ�� ", 0);
		if (q[d] != undefined) {
			c = 0;
			for (e = 0; e < q[d].length; e++) {
				if (q[d][e] == undefined) {
					continue;
				}
				if (f[7]) {
					if ((f[7] == true) && (d != 71) && (d != 81) && (d != 82)) {
						if ((e % 100) == 0) {
							continue;
						}
					}
				}
				o[c] = new Option(q[d][e], e);
				if (b == e) {
					o[c].selected = true;
				}
				c++;
			}
		}
		
		if (sub_arr[b] != undefined) {
			c = 0;
			for (e = 0; e < sub_arr[b].length; e++) {
				if (sub_arr[b][e] == undefined) {
					continue;
				}
				
				n[c] = new Option(sub_arr[b][e], e);
				if (l == e) {
					n[c].selected = true;
				}
				c++;
			}
		}
	}
}
//changeComplexProvince(v, sub_array, c+'City', c+'District');
function changeComplexProvince(f, k, e, d) {
	var c = changeComplexProvince.arguments;
	var h = document.getElementById(e);
	var g = document.getElementById(d);
	var b = 0;
	var a = 0;
	removeOptions(h);
	f = parseInt(f);
	if (k[f] != undefined) {
		for (b = 0; b < k[f].length; b++) {
			if (k[f][b] == undefined) {
				continue;
			}
			if (c[3]) {
				if ((c[3] == true) && (f != 71) && (f != 81) && (f != 82)) {
					if ((b % 100) == 0) {
						continue;
					}
				}
			}
			h[a] = new Option(k[f][b], b);
			a++;
		}
	}
	removeOptions(g);
	g[0] = new Option("��ѡ�� ", 0);
	if (f == 11 || f == 12 || f == 31 || f == 71 || f == 50 || f == 81
			|| f == 82) {
		if ($("#" + d)) {
			$("#" + d).hide();
		}
	} else {
		if ($("#" + d)) {
			$("#" + d).show();
		}
	}
}

function changeCity(c, a) {
	changeCity(c, a,sub_arr);
	}

function changeCity(c, a,sub_arr) {
	$("#" + a).html('<option value="0" >��ѡ��</option>');
	$("#" + a).unbind("change");
	c = parseInt(c);
	var _d = sub_arr[c];
	var str = "";
	str += "<option value='0' >��ѡ��</option>";
	for (var i = c * 100; i < _d.length; i++) {
		if (_d[i] == undefined)
			continue;
		str += "<option value='" + i + "' >" + _d[i] + "</option>";
	}
	$("#" + a).html(str);

}

function removeOptions(c) {
	if ((c != undefined) && (c.options != undefined)) {
		var a = c.options.length;
		for (var b = 0; b < a; b++) {
			c.options[0] = null;
		}
	}
}
