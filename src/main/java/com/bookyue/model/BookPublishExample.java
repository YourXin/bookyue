package com.bookyue.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookPublishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookPublishExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIsNull() {
            addCriterion("book_isbn is null");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIsNotNull() {
            addCriterion("book_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andBookIsbnEqualTo(String value) {
            addCriterion("book_isbn =", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotEqualTo(String value) {
            addCriterion("book_isbn <>", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnGreaterThan(String value) {
            addCriterion("book_isbn >", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("book_isbn >=", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLessThan(String value) {
            addCriterion("book_isbn <", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLessThanOrEqualTo(String value) {
            addCriterion("book_isbn <=", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLike(String value) {
            addCriterion("book_isbn like", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotLike(String value) {
            addCriterion("book_isbn not like", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIn(List<String> values) {
            addCriterion("book_isbn in", values, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotIn(List<String> values) {
            addCriterion("book_isbn not in", values, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnBetween(String value1, String value2) {
            addCriterion("book_isbn between", value1, value2, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotBetween(String value1, String value2) {
            addCriterion("book_isbn not between", value1, value2, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceIsNull() {
            addCriterion("book_prime_price is null");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceIsNotNull() {
            addCriterion("book_prime_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceEqualTo(BigDecimal value) {
            addCriterion("book_prime_price =", value, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceNotEqualTo(BigDecimal value) {
            addCriterion("book_prime_price <>", value, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceGreaterThan(BigDecimal value) {
            addCriterion("book_prime_price >", value, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("book_prime_price >=", value, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceLessThan(BigDecimal value) {
            addCriterion("book_prime_price <", value, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("book_prime_price <=", value, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceIn(List<BigDecimal> values) {
            addCriterion("book_prime_price in", values, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceNotIn(List<BigDecimal> values) {
            addCriterion("book_prime_price not in", values, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("book_prime_price between", value1, value2, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookPrimePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("book_prime_price not between", value1, value2, "bookPrimePrice");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookPublisherIsNull() {
            addCriterion("book_publisher is null");
            return (Criteria) this;
        }

        public Criteria andBookPublisherIsNotNull() {
            addCriterion("book_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andBookPublisherEqualTo(String value) {
            addCriterion("book_publisher =", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherNotEqualTo(String value) {
            addCriterion("book_publisher <>", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherGreaterThan(String value) {
            addCriterion("book_publisher >", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("book_publisher >=", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherLessThan(String value) {
            addCriterion("book_publisher <", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherLessThanOrEqualTo(String value) {
            addCriterion("book_publisher <=", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherLike(String value) {
            addCriterion("book_publisher like", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherNotLike(String value) {
            addCriterion("book_publisher not like", value, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherIn(List<String> values) {
            addCriterion("book_publisher in", values, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherNotIn(List<String> values) {
            addCriterion("book_publisher not in", values, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherBetween(String value1, String value2) {
            addCriterion("book_publisher between", value1, value2, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookPublisherNotBetween(String value1, String value2) {
            addCriterion("book_publisher not between", value1, value2, "bookPublisher");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceIsNull() {
            addCriterion("book_sell_price is null");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceIsNotNull() {
            addCriterion("book_sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceEqualTo(BigDecimal value) {
            addCriterion("book_sell_price =", value, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("book_sell_price <>", value, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceGreaterThan(BigDecimal value) {
            addCriterion("book_sell_price >", value, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("book_sell_price >=", value, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceLessThan(BigDecimal value) {
            addCriterion("book_sell_price <", value, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("book_sell_price <=", value, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceIn(List<BigDecimal> values) {
            addCriterion("book_sell_price in", values, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("book_sell_price not in", values, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("book_sell_price between", value1, value2, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("book_sell_price not between", value1, value2, "bookSellPrice");
            return (Criteria) this;
        }

        public Criteria andBookAmountIsNull() {
            addCriterion("book_amount is null");
            return (Criteria) this;
        }

        public Criteria andBookAmountIsNotNull() {
            addCriterion("book_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBookAmountEqualTo(Byte value) {
            addCriterion("book_amount =", value, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountNotEqualTo(Byte value) {
            addCriterion("book_amount <>", value, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountGreaterThan(Byte value) {
            addCriterion("book_amount >", value, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountGreaterThanOrEqualTo(Byte value) {
            addCriterion("book_amount >=", value, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountLessThan(Byte value) {
            addCriterion("book_amount <", value, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountLessThanOrEqualTo(Byte value) {
            addCriterion("book_amount <=", value, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountIn(List<Byte> values) {
            addCriterion("book_amount in", values, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountNotIn(List<Byte> values) {
            addCriterion("book_amount not in", values, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountBetween(Byte value1, Byte value2) {
            addCriterion("book_amount between", value1, value2, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookAmountNotBetween(Byte value1, Byte value2) {
            addCriterion("book_amount not between", value1, value2, "bookAmount");
            return (Criteria) this;
        }

        public Criteria andBookPicIsNull() {
            addCriterion("book_pic is null");
            return (Criteria) this;
        }

        public Criteria andBookPicIsNotNull() {
            addCriterion("book_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBookPicEqualTo(String value) {
            addCriterion("book_pic =", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotEqualTo(String value) {
            addCriterion("book_pic <>", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicGreaterThan(String value) {
            addCriterion("book_pic >", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicGreaterThanOrEqualTo(String value) {
            addCriterion("book_pic >=", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicLessThan(String value) {
            addCriterion("book_pic <", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicLessThanOrEqualTo(String value) {
            addCriterion("book_pic <=", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicLike(String value) {
            addCriterion("book_pic like", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotLike(String value) {
            addCriterion("book_pic not like", value, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicIn(List<String> values) {
            addCriterion("book_pic in", values, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotIn(List<String> values) {
            addCriterion("book_pic not in", values, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicBetween(String value1, String value2) {
            addCriterion("book_pic between", value1, value2, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookPicNotBetween(String value1, String value2) {
            addCriterion("book_pic not between", value1, value2, "bookPic");
            return (Criteria) this;
        }

        public Criteria andBookDescIsNull() {
            addCriterion("book_desc is null");
            return (Criteria) this;
        }

        public Criteria andBookDescIsNotNull() {
            addCriterion("book_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBookDescEqualTo(String value) {
            addCriterion("book_desc =", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotEqualTo(String value) {
            addCriterion("book_desc <>", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescGreaterThan(String value) {
            addCriterion("book_desc >", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescGreaterThanOrEqualTo(String value) {
            addCriterion("book_desc >=", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLessThan(String value) {
            addCriterion("book_desc <", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLessThanOrEqualTo(String value) {
            addCriterion("book_desc <=", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLike(String value) {
            addCriterion("book_desc like", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotLike(String value) {
            addCriterion("book_desc not like", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescIn(List<String> values) {
            addCriterion("book_desc in", values, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotIn(List<String> values) {
            addCriterion("book_desc not in", values, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescBetween(String value1, String value2) {
            addCriterion("book_desc between", value1, value2, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotBetween(String value1, String value2) {
            addCriterion("book_desc not between", value1, value2, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdIsNull() {
            addCriterion("book_type_id is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdIsNotNull() {
            addCriterion("book_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdEqualTo(Byte value) {
            addCriterion("book_type_id =", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdNotEqualTo(Byte value) {
            addCriterion("book_type_id <>", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdGreaterThan(Byte value) {
            addCriterion("book_type_id >", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("book_type_id >=", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdLessThan(Byte value) {
            addCriterion("book_type_id <", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("book_type_id <=", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdIn(List<Byte> values) {
            addCriterion("book_type_id in", values, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdNotIn(List<Byte> values) {
            addCriterion("book_type_id not in", values, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("book_type_id between", value1, value2, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("book_type_id not between", value1, value2, "bookTypeId");
            return (Criteria) this;
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

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIsNull() {
            addCriterion("publish_type is null");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIsNotNull() {
            addCriterion("publish_type is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTypeEqualTo(Byte value) {
            addCriterion("publish_type =", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotEqualTo(Byte value) {
            addCriterion("publish_type <>", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeGreaterThan(Byte value) {
            addCriterion("publish_type >", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("publish_type >=", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLessThan(Byte value) {
            addCriterion("publish_type <", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLessThanOrEqualTo(Byte value) {
            addCriterion("publish_type <=", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIn(List<Byte> values) {
            addCriterion("publish_type in", values, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotIn(List<Byte> values) {
            addCriterion("publish_type not in", values, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeBetween(Byte value1, Byte value2) {
            addCriterion("publish_type between", value1, value2, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("publish_type not between", value1, value2, "publishType");
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