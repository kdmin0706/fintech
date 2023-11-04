package com.zerobase.domain.domain

import javax.persistence.*

@Entity
@Table(name = "LOAN_REVIEW")
class LoanReview(
    @Column(name = "usr_key")
    val userKey: String,

    @Column(name = "loan_lmt_amt")
    val loanLimitedAmount: Long,

    @Column(name = "loan_intrt")
    val loanInterest: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}