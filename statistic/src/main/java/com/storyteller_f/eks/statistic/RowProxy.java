package com.storyteller_f.eks.statistic;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.odftoolkit.simple.table.Row;

import java.util.Iterator;

public class RowProxy implements org.apache.poi.ss.usermodel.Row {
    Row row;

    public RowProxy(Row row) {
        this.row = row;
    }

    @Override
    public org.apache.poi.ss.usermodel.Cell createCell(int column) {
        return null;
    }

    @Override
    public org.apache.poi.ss.usermodel.Cell createCell(int column, CellType type) {
        return null;
    }

    @Override
    public void removeCell(org.apache.poi.ss.usermodel.Cell cell) {

    }

    @Override
    public int getRowNum() {
        return 0;
    }

    @Override
    public void setRowNum(int rowNum) {

    }

    @Override
    public org.apache.poi.ss.usermodel.Cell getCell(int cellnum) {
        return new CellProxy(row.getCellByIndex(cellnum));
    }

    @Override
    public org.apache.poi.ss.usermodel.Cell getCell(int cellnum, MissingCellPolicy policy) {
        return null;
    }

    @Override
    public short getFirstCellNum() {
        return 0;
    }

    @Override
    public short getLastCellNum() {
        return 0;
    }

    @Override
    public int getPhysicalNumberOfCells() {
        return 0;
    }

    @Override
    public boolean getZeroHeight() {
        return false;
    }

    @Override
    public void setZeroHeight(boolean zHeight) {

    }

    @Override
    public short getHeight() {
        return 0;
    }

    @Override
    public void setHeight(short height) {

    }

    @Override
    public float getHeightInPoints() {
        return 0;
    }

    @Override
    public void setHeightInPoints(float height) {

    }

    @Override
    public boolean isFormatted() {
        return false;
    }

    @Override
    public CellStyle getRowStyle() {
        return null;
    }

    @Override
    public void setRowStyle(CellStyle style) {

    }

    @Override
    public Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator() {
        return null;
    }

    @Override
    public Sheet getSheet() {
        return null;
    }

    @Override
    public int getOutlineLevel() {
        return 0;
    }

    @Override
    public void shiftCellsRight(int firstShiftColumnIndex, int lastShiftColumnIndex, int step) {

    }

    @Override
    public void shiftCellsLeft(int firstShiftColumnIndex, int lastShiftColumnIndex, int step) {

    }

    @Override
    public Iterator<org.apache.poi.ss.usermodel.Cell> iterator() {
        return null;
    }
}
