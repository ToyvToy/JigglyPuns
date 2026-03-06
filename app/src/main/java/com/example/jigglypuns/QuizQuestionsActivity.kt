package com.example.jigglypuns

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var buttonSubmit: Button? = null

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        setQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)

        enableEdgeToEdge()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setQuestion() {
        val questions: Questions =
            mQuestionList!![mCurrentPosition -1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size) {
            buttonSubmit?.text = "FINISH"
        } else {
            buttonSubmit?.text = "SUBMIT"
        }

        progressBar?.progress = mCurrentPosition!!
        tvProgress?.text = "$mCurrentPosition" + "/" + progressBar?.max

        tvQuestion?.text = questions.question
        ivImage?.setImageResource(questions.image)
        tvOptionOne?.text = questions.optionOne
        tvOptionTwo?.text = questions.optionTwo
        tvOptionThree?.text = questions.optionThree
        tvOptionFour?.text = questions.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }

        tvOptionTwo?.let {
            options.add(1, it)
        }

        tvOptionThree?.let {
            options.add(2, it)
        }

        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border
            )
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {

                            setQuestion()
                        }
                        else -> {
                            val intent =
                                Intent(this@QuizQuestionsActivity, ResultsActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        buttonSubmit?.text = "FINISH"
                    } else {
                        buttonSubmit?.text = "GO TO THE NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border
        )
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {

            1-> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

            2-> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

            3-> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }

            4-> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}