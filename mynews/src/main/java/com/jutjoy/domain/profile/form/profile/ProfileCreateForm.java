package com.jutjoy.domain.profile.form.profile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProfileCreateForm {

	//バリデーション
	//名前
	@NotEmpty(message = "*名前は必ず入力してください。")
	private String name;
	
	//性別
	@NotEmpty(message = "*性別は必ず選択してください。")
	private String gender;
	
	//趣味
	@NotEmpty(message = "*趣味は必ず入力してください。")
	@Size(max = 200, message = "＊趣味は200文字以内で設定してください。")
	private String hobby;
	
	//自己紹介
	@NotEmpty(message = "*自己紹介は必ず入力してください。")
	private String introduction;
}
