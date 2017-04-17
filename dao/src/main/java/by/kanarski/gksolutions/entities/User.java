package by.kanarski.gksolutions.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AbstractEntity {

    private static final long serialVersionUID = 755092399090937570L;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String skype;
    private Set<Phone> phoneSet;
    private Company company;
    private Set<User> childUsersSet;
    private User parentUser;
    private Timestamp createTime;
    private Set<Role> roleSet;
    private Status userStatus;

    @Builder
    public User(Integer userId, String password, String firstName, String middleName, String lastName, String email,
                String skype, Set<Phone> phoneSet, Company company, Set<User> childUsersSet, User parentUser,
                Timestamp createTime, Set<Role> roleSet, Status userStatus) {
        setId(userId);
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.skype = skype;
        this.phoneSet = phoneSet;
        this.company = company;
        this.childUsersSet = childUsersSet;
        this.parentUser = parentUser;
        this.createTime = createTime;
        this.roleSet = roleSet;
        this.userStatus = userStatus;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany
    @JoinTable(
            name = "user_phones",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_phone")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "phone_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_phone_user")
            )
    )
    public Set<Phone> getPhoneSet() {
        return phoneSet;
    }

    public void setPhoneSet(Set<Phone> phoneSet) {
        this.phoneSet = phoneSet;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @OneToMany
    public Set<User> getChildUsersSet() {
        return childUsersSet;
    }

    public void setChildUsersSet(Set<User> childUsersSet) {
        this.childUsersSet = childUsersSet;
    }

    @ManyToOne
    public User getParentUser() {
        return parentUser;
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }

    @Column(nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Column(
            unique = true,
            nullable = false
    )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(unique = true)
    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @ManyToMany
    @JoinTable(
            name = "user_user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_phone")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_role_user")
            )
    )
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @ManyToOne
    @JoinColumn(
            name = "status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_status")
    )
    public Status getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Status userStatus) {
        this.userStatus = userStatus;
    }

    public enum Fields {firstName, middleName, lastName, email, password, skype, phoneSet, company, childUsersSet, parentUser, createTime, roleSet, userStatus, serialVersionUID}
}
