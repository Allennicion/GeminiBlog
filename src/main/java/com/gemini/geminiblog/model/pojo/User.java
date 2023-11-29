package com.gemini.geminiblog.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @author zhangwj
 * @date 2022/10/19 16:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @TableId(type = IdType.UUID)
    private String id;              // 主键Id
    @NotEmpty(message = "账号不能为空！")
    private String username;    // 账号
    @NotEmpty(message = "密码不能为空！")
    private String password;    // 密码
    private Integer role;       // 权限
    private String avatar;      // 头像
    private String email;       // 邮箱
    private String nickname;    // 昵称
    private Integer isEnable;   // 是否启用 0:否 1:是
    private String openId;      // 外键Id
    private String createName;  // 创建人
    private Date createTime;    // 创建时间
    private String updateName;  // 更新人
    private Date updateTime;    // 更新时间
    @Builder.Default
    private Integer isDel = 0;  // 是否删除 0:否 1:是

}
