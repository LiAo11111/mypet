package com.aoyue.mypet;

import android.animation.ValueAnimator;

import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;

import android.util.AttributeSet;

import android.util.Log;

import android.view.View;

/**
 * Date:2018/11/27
 * <p>
 * Author:WangTingting
 * <p>
 * 说明:自定义信用等级
 */

public class MyProgressView extends View {

    private Paint mCircleOutPaint;

    private Paint mCircleInPaint;

    private Paint mLinePaint;

    private Paint mDefaltCircleOutPaint;

    private Paint mDefaltCircleInPaint;

    private Paint mDefaltLinePaint;

    private Paint mTvPaint;

    private int circleOutRadius = 16;

    private int circleInRadius = 8;

    private int margin = 60; //左右margin

    private float mProgress;

    private ValueAnimator animation;

    public MyProgressView(Context context) {

        super(context);

        initView();

    }

    public MyProgressView(Context context, AttributeSet attrs) {

        super(context, attrs);

        initView();

    }

    public MyProgressView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        initView();

    }

    public void initView() {

        mCircleOutPaint = new Paint();

        mCircleOutPaint.setStyle(Paint.Style.FILL);

        mCircleOutPaint.setColor(Color.parseColor("#40A5FF"));

        mCircleOutPaint.setAntiAlias(true);

        mCircleInPaint = new Paint();

        mCircleInPaint.setStyle(Paint.Style.FILL);

        mCircleInPaint.setColor(Color.WHITE);

        mCircleInPaint.setAntiAlias(true);

        mLinePaint = new Paint();

        mLinePaint.setColor(Color.parseColor("#40A5FF"));

        mLinePaint.setStrokeWidth(8);

        mDefaltCircleOutPaint = new Paint();

        mDefaltCircleOutPaint.setStyle(Paint.Style.FILL);

        mDefaltCircleOutPaint.setColor(Color.parseColor("#858585"));

        mDefaltCircleOutPaint.setAntiAlias(true);

        mDefaltCircleInPaint = new Paint();

        mDefaltCircleInPaint.setStyle(Paint.Style.FILL);

        mDefaltCircleInPaint.setColor(Color.WHITE);

        mDefaltCircleInPaint.setAntiAlias(true);

        mDefaltLinePaint = new Paint();

        mDefaltLinePaint.setColor(Color.parseColor("#858585"));

        mDefaltLinePaint.setStrokeWidth(8);

        mTvPaint = new Paint();

        mTvPaint.setColor(Color.parseColor("#858585"));

        mTvPaint.setTextSize(sp2px(getContext(), 12));

    }

    public void setProgress(float progress) {

        if (animation == null) {

            animation = ValueAnimator.ofFloat(0f, Float.valueOf(progress));

        }

        if (progress > 0 && progress <= 400) {

            mLinePaint.setColor(getResources().getColor(R.color.yellow));

            mCircleOutPaint.setColor(getResources().getColor(R.color.yellow));

        } else if (progress > 400 && progress <= 700) {

            mLinePaint.setColor(getResources().getColor(R.color.mediumslateblue));

            mCircleOutPaint.setColor(getResources().getColor(R.color.mediumslateblue));

        } else if (progress > 700 && progress <= 900) {

            mLinePaint.setColor(getResources().getColor(R.color.green));

            mCircleOutPaint.setColor(getResources().getColor(R.color.green));

        } else if (progress > 900) {

            mLinePaint.setColor(getResources().getColor(R.color.coral));

            mCircleOutPaint.setColor(getResources().getColor(R.color.coral));

        }

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override

            public void onAnimationUpdate(ValueAnimator animation) {

                mProgress = (float) animation.getAnimatedValue();

                invalidate();

            }

        });

        animation.setDuration(3000);

        animation.start();

    }

    @Override

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        getSuggestedMinimumWidth();

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override

    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int height = getHeight();

        int width = getWidth();

        int realWidth = (width - 2 * margin - 8 * circleOutRadius) / 3;

        canvas.drawLine(margin + circleOutRadius * 2, height / 2, width - margin - circleOutRadius * 2, height / 2, mDefaltLinePaint);

        for (int i = 0; i < 4; i++) {

            canvas.drawCircle(margin + circleOutRadius * (i * 2 + 1) + realWidth * i, height / 2, circleOutRadius, mDefaltCircleOutPaint);

            canvas.drawCircle(margin + circleOutRadius * (i * 2 + 1) + realWidth * i, height / 2, circleInRadius, mDefaltCircleInPaint);

        }

        canvas.drawText("0", margin + circleOutRadius - getTextWidth("0"), height / 2 - 30, mTvPaint);

        canvas.drawText("400", margin + circleOutRadius * 3 + realWidth - getTextWidth("400"), height / 2 - 30, mTvPaint);

        canvas.drawText("700", margin + circleOutRadius * 5 + realWidth * 2 - getTextWidth("700"), height / 2 - 30, mTvPaint);

        canvas.drawText("900+", margin + circleOutRadius * 7 + realWidth * 3 - getTextWidth("900+"), height / 2 - 30, mTvPaint);

        canvas.drawText("出生", margin + circleOutRadius - getTextWidth("出生"), height / 2 + 50, mTvPaint);

        canvas.drawText("幼年期", margin + circleOutRadius * 3 + realWidth - getTextWidth("幼年期"), height / 2 + 50, mTvPaint);

        canvas.drawText("中年期", margin + circleOutRadius * 5 + realWidth * 2 - getTextWidth("中年期"), height / 2 + 50, mTvPaint);

        canvas.drawText("晚年期", margin + circleOutRadius * 7 + realWidth * 3 - getTextWidth("晚年期"), height / 2 + 50, mTvPaint);

        float ratio;

        float result = 0;

        if (mProgress > 0 && mProgress <= 400) {

            ratio = mProgress / 400;

            result = margin + circleOutRadius * 2 + (ratio * realWidth);

        } else if (mProgress > 400 && mProgress <= 700) {

            ratio = (mProgress - 400) / 300;

            result = margin + circleOutRadius * 4 + (ratio * realWidth) + realWidth;

        } else if (mProgress > 700 && mProgress <= 900) {

            ratio = (mProgress - 700) / 200;

            result = margin + circleOutRadius * 6 + realWidth * 2 + (ratio * realWidth);

        } else if (mProgress > 900) {

            result = margin + circleOutRadius * 8 + 3 * realWidth;

        }

        canvas.drawLine(margin + circleOutRadius, height / 2, result, height / 2, mLinePaint);

        if (mProgress <= 0) {

            return;

        }

        canvas.drawCircle(margin + circleOutRadius, height / 2, circleOutRadius, mCircleOutPaint);

        canvas.drawCircle(margin + circleOutRadius, height / 2, circleInRadius, mCircleInPaint);

        if (mProgress <= 400) {

            return;

        }

        canvas.drawCircle(margin + circleOutRadius * 3 + realWidth, height / 2, circleOutRadius, mCircleOutPaint);

        canvas.drawCircle(margin + circleOutRadius * 3 + realWidth, height / 2, circleInRadius, mCircleInPaint);

        if (mProgress <= 700) {

            return;

        }

        canvas.drawCircle(margin + circleOutRadius * 5 + realWidth * 2, height / 2, circleOutRadius, mCircleOutPaint);

        canvas.drawCircle(margin + circleOutRadius * 5 + realWidth * 2, height / 2, circleInRadius, mCircleInPaint);

        if (mProgress <= 900) {

            return;

        }

        canvas.drawCircle(margin + circleOutRadius * 7 + realWidth * 3, height / 2, circleOutRadius, mCircleOutPaint);

        canvas.drawCircle(margin + circleOutRadius * 7 + realWidth * 3, height / 2, circleInRadius, mCircleInPaint);

    }

    public float getTextWidth(String text) {

        return mTvPaint.measureText(text) / 2;

    }

    public static int sp2px(Context context, float spValue) {

        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int) (spValue * fontScale + 0.5f);

    }

}