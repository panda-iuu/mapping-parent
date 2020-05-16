package com.aaa.lifuju.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.base
 * @ClassName: BaseModel
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/12 11:22
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseModel implements Serializable {
    @Id
    @NotNull
    private long id;

    @Column(name="create_time")
    @Max(value = 100,message = "时间长度不能超过一百")
    private String createTime;

    @Column(name = "modify_time")
    @Max(value = 100,message = "时间长度不能超过一百")
    private String modifyTime;

}
