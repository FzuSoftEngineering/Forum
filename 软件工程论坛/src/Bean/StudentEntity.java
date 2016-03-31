package Bean;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "student")
public class StudentEntity extends UserEntity  {

    private String major;           //专业
    private String clazz;           //班级


    @ManyToOne(fetch = FetchType.EAGER)
    private TeacherEntity teacherEntity;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<StudentEntity> friends;



    /*学生权限表
    * 下载文件的权限
    * 上传作业的权限
    * 发帖 评论
    * 管理权限   包括管理学生,老师信息,删帖,禁言.
    * */







    public StudentEntity() {
    }

    public StudentEntity(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public StudentEntity(int id, String password, String nickname, Date birthDate, String cellPhone, String email, String address) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
        this.email = email;
        this.address = address;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (cellPhone != null ? !cellPhone.equals(that.cellPhone) : that.cellPhone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
