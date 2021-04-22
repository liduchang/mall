/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.javaboy.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@qq.com
 */
public class Resp extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Resp() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static Resp error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static Resp error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static Resp error(int code, String msg) {
		Resp r = new Resp();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Resp ok(String msg) {
		Resp r = new Resp();
		r.put("msg", msg);
		return r;
	}
	
	public static Resp ok(Map<String, Object> map) {
		Resp r = new Resp();
		r.putAll(map);
		return r;
	}
	
	public static Resp ok() {
		return new Resp();
	}

	public Resp put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	public  Integer getCode() {

		return (Integer) this.get("code");
	}

}
