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
    private String id;          // 主键Id
    @NotEmpty(message = "分类名称不能为空！")
    private String name;        // 分类名称
    private String createName;  // 创建人
    private Date createTime;    // 创建时间
    private String updateName;  // 更新人
    private Date updateTime;    // 更新时间
    @Builder.Default
    private Integer isDel = 0;  // 是否删除 0:否 1:是
}
