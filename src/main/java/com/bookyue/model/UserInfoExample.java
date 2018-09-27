package com.bookyue.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidIsNull() {
            addCriterion("user_wxopenid is null");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidIsNotNull() {
            addCriterion("user_wxopenid is not null");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidEqualTo(String value) {
            addCriterion("user_wxopenid =", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidNotEqualTo(String value) {
            addCriterion("user_wxopenid <>", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidGreaterThan(String value) {
            addCriterion("user_wxopenid >", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidGreaterThanOrEqualTo(String value) {
            addCriterion("user_wxopenid >=", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidLessThan(String value) {
            addCriterion("user_wxopenid <", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidLessThanOrEqualTo(String value) {
            addCriterion("user_wxopenid <=", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidLike(String value) {
            addCriterion("user_wxopenid like", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidNotLike(String value) {
            addCriterion("user_wxopenid not like", value, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidIn(List<String> values) {
            addCriterion("user_wxopenid in", values, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidNotIn(List<String> values) {
            addCriterion("user_wxopenid not in", values, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidBetween(String value1, String value2) {
            addCriterion("user_wxopenid between", value1, value2, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserWxopenidNotBetween(String value1, String value2) {
            addCriterion("user_wxopenid not between", value1, value2, "userWxopenid");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Byte value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Byte value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Byte value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Byte value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Byte value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Byte> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Byte> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Byte value1, Byte value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Byte value1, Byte value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdIsNull() {
            addCriterion("user_school_id is null");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdIsNotNull() {
            addCriterion("user_school_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdEqualTo(Short value) {
            addCriterion("user_school_id =", value, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdNotEqualTo(Short value) {
            addCriterion("user_school_id <>", value, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdGreaterThan(Short value) {
            addCriterion("user_school_id >", value, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdGreaterThanOrEqualTo(Short value) {
            addCriterion("user_school_id >=", value, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdLessThan(Short value) {
            addCriterion("user_school_id <", value, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdLessThanOrEqualTo(Short value) {
            addCriterion("user_school_id <=", value, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdIn(List<Short> values) {
            addCriterion("user_school_id in", values, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdNotIn(List<Short> values) {
            addCriterion("user_school_id not in", values, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdBetween(Short value1, Short value2) {
            addCriterion("user_school_id between", value1, value2, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIdNotBetween(Short value1, Short value2) {
            addCriterion("user_school_id not between", value1, value2, "userSchoolId");
            return (Criteria) this;
        }

        public Criteria andUserMajorIsNull() {
            addCriterion("user_major is null");
            return (Criteria) this;
        }

        public Criteria andUserMajorIsNotNull() {
            addCriterion("user_major is not null");
            return (Criteria) this;
        }

        public Criteria andUserMajorEqualTo(String value) {
            addCriterion("user_major =", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorNotEqualTo(String value) {
            addCriterion("user_major <>", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorGreaterThan(String value) {
            addCriterion("user_major >", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorGreaterThanOrEqualTo(String value) {
            addCriterion("user_major >=", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorLessThan(String value) {
            addCriterion("user_major <", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorLessThanOrEqualTo(String value) {
            addCriterion("user_major <=", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorLike(String value) {
            addCriterion("user_major like", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorNotLike(String value) {
            addCriterion("user_major not like", value, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorIn(List<String> values) {
            addCriterion("user_major in", values, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorNotIn(List<String> values) {
            addCriterion("user_major not in", values, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorBetween(String value1, String value2) {
            addCriterion("user_major between", value1, value2, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserMajorNotBetween(String value1, String value2) {
            addCriterion("user_major not between", value1, value2, "userMajor");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsIsNull() {
            addCriterion("user_bonus_points is null");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsIsNotNull() {
            addCriterion("user_bonus_points is not null");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsEqualTo(Integer value) {
            addCriterion("user_bonus_points =", value, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsNotEqualTo(Integer value) {
            addCriterion("user_bonus_points <>", value, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsGreaterThan(Integer value) {
            addCriterion("user_bonus_points >", value, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_bonus_points >=", value, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsLessThan(Integer value) {
            addCriterion("user_bonus_points <", value, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsLessThanOrEqualTo(Integer value) {
            addCriterion("user_bonus_points <=", value, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsIn(List<Integer> values) {
            addCriterion("user_bonus_points in", values, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsNotIn(List<Integer> values) {
            addCriterion("user_bonus_points not in", values, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsBetween(Integer value1, Integer value2) {
            addCriterion("user_bonus_points between", value1, value2, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserBonusPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("user_bonus_points not between", value1, value2, "userBonusPoints");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIsNull() {
            addCriterion("user_type_id is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIsNotNull() {
            addCriterion("user_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdEqualTo(Byte value) {
            addCriterion("user_type_id =", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotEqualTo(Byte value) {
            addCriterion("user_type_id <>", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdGreaterThan(Byte value) {
            addCriterion("user_type_id >", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_type_id >=", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdLessThan(Byte value) {
            addCriterion("user_type_id <", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("user_type_id <=", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIn(List<Byte> values) {
            addCriterion("user_type_id in", values, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotIn(List<Byte> values) {
            addCriterion("user_type_id not in", values, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("user_type_id between", value1, value2, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("user_type_id not between", value1, value2, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlIsNull() {
            addCriterion("user_avatar_url is null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlIsNotNull() {
            addCriterion("user_avatar_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlEqualTo(String value) {
            addCriterion("user_avatar_url =", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotEqualTo(String value) {
            addCriterion("user_avatar_url <>", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlGreaterThan(String value) {
            addCriterion("user_avatar_url >", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_avatar_url >=", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlLessThan(String value) {
            addCriterion("user_avatar_url <", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlLessThanOrEqualTo(String value) {
            addCriterion("user_avatar_url <=", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlLike(String value) {
            addCriterion("user_avatar_url like", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotLike(String value) {
            addCriterion("user_avatar_url not like", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlIn(List<String> values) {
            addCriterion("user_avatar_url in", values, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotIn(List<String> values) {
            addCriterion("user_avatar_url not in", values, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlBetween(String value1, String value2) {
            addCriterion("user_avatar_url between", value1, value2, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotBetween(String value1, String value2) {
            addCriterion("user_avatar_url not between", value1, value2, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNull() {
            addCriterion("user_create_time is null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNotNull() {
            addCriterion("user_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeEqualTo(Date value) {
            addCriterion("user_create_time =", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotEqualTo(Date value) {
            addCriterion("user_create_time <>", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThan(Date value) {
            addCriterion("user_create_time >", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_create_time >=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThan(Date value) {
            addCriterion("user_create_time <", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_create_time <=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIn(List<Date> values) {
            addCriterion("user_create_time in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotIn(List<Date> values) {
            addCriterion("user_create_time not in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeBetween(Date value1, Date value2) {
            addCriterion("user_create_time between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_create_time not between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeIsNull() {
            addCriterion("vertify_code is null");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeIsNotNull() {
            addCriterion("vertify_code is not null");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeEqualTo(String value) {
            addCriterion("vertify_code =", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeNotEqualTo(String value) {
            addCriterion("vertify_code <>", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeGreaterThan(String value) {
            addCriterion("vertify_code >", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vertify_code >=", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeLessThan(String value) {
            addCriterion("vertify_code <", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeLessThanOrEqualTo(String value) {
            addCriterion("vertify_code <=", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeLike(String value) {
            addCriterion("vertify_code like", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeNotLike(String value) {
            addCriterion("vertify_code not like", value, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeIn(List<String> values) {
            addCriterion("vertify_code in", values, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeNotIn(List<String> values) {
            addCriterion("vertify_code not in", values, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeBetween(String value1, String value2) {
            addCriterion("vertify_code between", value1, value2, "vertifyCode");
            return (Criteria) this;
        }

        public Criteria andVertifyCodeNotBetween(String value1, String value2) {
            addCriterion("vertify_code not between", value1, value2, "vertifyCode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}