package com.exercise.part1.data;

/**
 *
 * Created by Denis on 2016-01-14.
 */
public class ParseResult <L, R, W>
{
    private L leftOperand;
    private R rightOperand;
    private W wireId;

    public ParseResult(L leftOperand, R rightOperand, W wireId)
    {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.wireId = wireId;
    }

    public L getLeftOperand() {
        return leftOperand;
    }

    public R getRightOperand() {
        return rightOperand;
    }

    public W getWireId() {
        return wireId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParseResult)) return false;

        ParseResult that = (ParseResult) o;

        if (leftOperand != null ? !leftOperand.equals(that.leftOperand) : that.leftOperand != null) return false;
        if (rightOperand != null ? !rightOperand.equals(that.rightOperand) : that.rightOperand != null) return false;
        if (wireId != null ? !wireId.equals(that.wireId) : that.wireId != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = leftOperand != null ? leftOperand.hashCode() : 0;
        result = 31 * result + (rightOperand != null ? rightOperand.hashCode() : 0);
        result = 31 * result + (wireId != null ? wireId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParseResult{" +
                "leftOperand=" + leftOperand +
                ", rightOperand=" + rightOperand +
                ", wireId=" + wireId +
                '}';
    }
}
