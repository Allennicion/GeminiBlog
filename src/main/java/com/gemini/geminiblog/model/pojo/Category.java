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
 * 分类管理实体类
 * @author zhangwj
 * @date 2022/10/10 21:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @TableId(type = IdType.UUID)
    private String id;
    @NotEmpty(message = "分类名称不能为空！")
    private String name;
    private String createName;
    private Date createTime;
    private String updateName;

    private Date updateTime;
    @Builder.Default
    private Integer isDel = 0;
}
