package com.ht.common.utils;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 0);
		put("msg", "操作成功");
	}

	public static R error() {
		return error(1, "操作失败");
	}
	
	public static R no() {
		return error(2, "没有权限");
	}
	
	public static R repeat() {
		return error(4, "重复操作");
	}
	
	public static R done() {
		return error(5, "已经完成");
	}
	
	public static R userIsNull() {
		return error(3, "请选择用户");
	}
	
	public static R typeIsNull() {
		return error(4, "请选择请求类型");
	}
	
	
	
	public static R srcIsNull() {
		return error(5, "请选择请求来源");
	}
	
	public static R drugTypeIsNull() {
		return error(6, "请选择药品类型");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
