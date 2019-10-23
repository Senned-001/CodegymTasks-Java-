package com.codegym.task.task25.task2503;

public interface Columnable {

    /**
     * @return full column name
     */
    String getColumnName();

    /**
     * Returns true if the column is visible, otherwise false
     */
    boolean isShown();

    /**
     * Hides the column by marking it with -1 in the realOrder array.
     * Shifts the indices of the visible columns that come after the hidden column
     */
    void hide();

    /**
     * Returns the constant's ordinal number in the enum.
     *
     * @return the constant's ordinal number in the enum
     */
    int ordinal();
}
