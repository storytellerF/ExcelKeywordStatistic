package com.storyteller_f.eks.statistic;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SheetProxy implements Sheet {
    org.odftoolkit.simple.table.Table table;

    public SheetProxy(org.odftoolkit.simple.table.Table table) {
        this.table=table;
    }

    @Override
    public Row createRow(int rownum) {
        return null;
    }

    @Override
    public void removeRow(Row row) {

    }

    @Override
    public Row getRow(int rownum) {
        return new RowProxy(table.getRowByIndex(rownum));
    }

    @Override
    public int getPhysicalNumberOfRows() {
        return 0;
    }

    @Override
    public int getFirstRowNum() {
        return 0;
    }

    @Override
    public int getLastRowNum() {
        return 0;
    }

    @Override
    public void setColumnHidden(int columnIndex, boolean hidden) {

    }

    @Override
    public boolean isColumnHidden(int columnIndex) {
        return false;
    }

    @Override
    public boolean isRightToLeft() {
        return false;
    }

    @Override
    public void setRightToLeft(boolean value) {

    }

    @Override
    public void setColumnWidth(int columnIndex, int width) {

    }

    @Override
    public int getColumnWidth(int columnIndex) {
        return 0;
    }

    @Override
    public float getColumnWidthInPixels(int columnIndex) {
        return 0;
    }

    @Override
    public int getDefaultColumnWidth() {
        return 0;
    }

    @Override
    public void setDefaultColumnWidth(int width) {

    }

    @Override
    public short getDefaultRowHeight() {
        return 0;
    }

    @Override
    public void setDefaultRowHeight(short height) {

    }

    @Override
    public float getDefaultRowHeightInPoints() {
        return 0;
    }

    @Override
    public void setDefaultRowHeightInPoints(float height) {

    }

    @Override
    public CellStyle getColumnStyle(int column) {
        return null;
    }

    @Override
    public int addMergedRegion(CellRangeAddress region) {
        return 0;
    }

    @Override
    public int addMergedRegionUnsafe(CellRangeAddress region) {
        return 0;
    }

    @Override
    public void validateMergedRegions() {

    }

    @Override
    public boolean getHorizontallyCenter() {
        return false;
    }

    @Override
    public void setHorizontallyCenter(boolean value) {

    }

    @Override
    public boolean getVerticallyCenter() {
        return false;
    }

    @Override
    public void setVerticallyCenter(boolean value) {

    }

    @Override
    public void removeMergedRegion(int index) {

    }

    @Override
    public void removeMergedRegions(Collection<Integer> indices) {

    }

    @Override
    public int getNumMergedRegions() {
        return 0;
    }

    @Override
    public CellRangeAddress getMergedRegion(int index) {
        return null;
    }

    @Override
    public List<CellRangeAddress> getMergedRegions() {
        return null;
    }

    @Override
    public Iterator<Row> rowIterator() {
        return null;
    }

    @Override
    public boolean getForceFormulaRecalculation() {
        return false;
    }

    @Override
    public void setForceFormulaRecalculation(boolean value) {

    }

    @Override
    public boolean isDisplayZeros() {
        return false;
    }

    @Override
    public void setDisplayZeros(boolean value) {

    }

    @Override
    public boolean getAutobreaks() {
        return false;
    }

    @Override
    public void setAutobreaks(boolean value) {

    }

    @Override
    public boolean getDisplayGuts() {
        return false;
    }

    @Override
    public void setDisplayGuts(boolean value) {

    }

    @Override
    public boolean getFitToPage() {
        return false;
    }

    @Override
    public void setFitToPage(boolean value) {

    }

    @Override
    public boolean getRowSumsBelow() {
        return false;
    }

    @Override
    public void setRowSumsBelow(boolean value) {

    }

    @Override
    public boolean getRowSumsRight() {
        return false;
    }

    @Override
    public void setRowSumsRight(boolean value) {

    }

    @Override
    public boolean isPrintGridlines() {
        return false;
    }

    @Override
    public void setPrintGridlines(boolean show) {

    }

    @Override
    public boolean isPrintRowAndColumnHeadings() {
        return false;
    }

    @Override
    public void setPrintRowAndColumnHeadings(boolean show) {

    }

    @Override
    public PrintSetup getPrintSetup() {
        return null;
    }

    @Override
    public Header getHeader() {
        return null;
    }

    @Override
    public Footer getFooter() {
        return null;
    }

    @Override
    public double getMargin(short margin) {
        return 0;
    }

    @Override
    public void setMargin(short margin, double size) {

    }

    @Override
    public boolean getProtect() {
        return false;
    }

    @Override
    public void protectSheet(String password) {

    }

    @Override
    public boolean getScenarioProtect() {
        return false;
    }

    @Override
    public void setZoom(int scale) {

    }

    @Override
    public short getTopRow() {
        return 0;
    }

    @Override
    public short getLeftCol() {
        return 0;
    }

    @Override
    public void showInPane(int topRow, int leftCol) {

    }

    @Override
    public void shiftRows(int startRow, int endRow, int n) {

    }

    @Override
    public void shiftRows(int startRow, int endRow, int n, boolean copyRowHeight, boolean resetOriginalRowHeight) {

    }

    @Override
    public void shiftColumns(int startColumn, int endColumn, int n) {

    }

    @Override
    public void createFreezePane(int colSplit, int rowSplit, int leftmostColumn, int topRow) {

    }

    @Override
    public void createFreezePane(int colSplit, int rowSplit) {

    }

    @Override
    public void createSplitPane(int xSplitPos, int ySplitPos, int leftmostColumn, int topRow, int activePane) {

    }

    @Override
    public PaneInformation getPaneInformation() {
        return null;
    }

    @Override
    public boolean isDisplayGridlines() {
        return false;
    }

    @Override
    public void setDisplayGridlines(boolean show) {

    }

    @Override
    public boolean isDisplayFormulas() {
        return false;
    }

    @Override
    public void setDisplayFormulas(boolean show) {

    }

    @Override
    public boolean isDisplayRowColHeadings() {
        return false;
    }

    @Override
    public void setDisplayRowColHeadings(boolean show) {

    }

    @Override
    public void setRowBreak(int row) {

    }

    @Override
    public boolean isRowBroken(int row) {
        return false;
    }

    @Override
    public void removeRowBreak(int row) {

    }

    @Override
    public int[] getRowBreaks() {
        return new int[0];
    }

    @Override
    public int[] getColumnBreaks() {
        return new int[0];
    }

    @Override
    public void setColumnBreak(int column) {

    }

    @Override
    public boolean isColumnBroken(int column) {
        return false;
    }

    @Override
    public void removeColumnBreak(int column) {

    }

    @Override
    public void setColumnGroupCollapsed(int columnNumber, boolean collapsed) {

    }

    @Override
    public void groupColumn(int fromColumn, int toColumn) {

    }

    @Override
    public void ungroupColumn(int fromColumn, int toColumn) {

    }

    @Override
    public void groupRow(int fromRow, int toRow) {

    }

    @Override
    public void ungroupRow(int fromRow, int toRow) {

    }

    @Override
    public void setRowGroupCollapsed(int row, boolean collapse) {

    }

    @Override
    public void setDefaultColumnStyle(int column, CellStyle style) {

    }

    @Override
    public void autoSizeColumn(int column) {

    }

    @Override
    public void autoSizeColumn(int column, boolean useMergedCells) {

    }

    @Override
    public Comment getCellComment(CellAddress ref) {
        return null;
    }

    @Override
    public Map<CellAddress, ? extends Comment> getCellComments() {
        return null;
    }

    @Override
    public Drawing<?> getDrawingPatriarch() {
        return null;
    }

    @Override
    public Drawing<?> createDrawingPatriarch() {
        return null;
    }

    @Override
    public Workbook getWorkbook() {
        return null;
    }

    @Override
    public String getSheetName() {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected(boolean value) {

    }

    @Override
    public CellRange<? extends Cell> setArrayFormula(String formula, CellRangeAddress range) {
        return null;
    }

    @Override
    public CellRange<? extends Cell> removeArrayFormula(Cell cell) {
        return null;
    }

    @Override
    public DataValidationHelper getDataValidationHelper() {
        return null;
    }

    @Override
    public List<? extends DataValidation> getDataValidations() {
        return null;
    }

    @Override
    public void addValidationData(DataValidation dataValidation) {

    }

    @Override
    public AutoFilter setAutoFilter(CellRangeAddress range) {
        return null;
    }

    @Override
    public SheetConditionalFormatting getSheetConditionalFormatting() {
        return null;
    }

    @Override
    public CellRangeAddress getRepeatingRows() {
        return null;
    }

    @Override
    public void setRepeatingRows(CellRangeAddress rowRangeRef) {

    }

    @Override
    public CellRangeAddress getRepeatingColumns() {
        return null;
    }

    @Override
    public void setRepeatingColumns(CellRangeAddress columnRangeRef) {

    }

    @Override
    public int getColumnOutlineLevel(int columnIndex) {
        return 0;
    }

    @Override
    public Hyperlink getHyperlink(int row, int column) {
        return null;
    }

    @Override
    public Hyperlink getHyperlink(CellAddress addr) {
        return null;
    }

    @Override
    public List<? extends Hyperlink> getHyperlinkList() {
        return null;
    }

    @Override
    public CellAddress getActiveCell() {
        return null;
    }

    @Override
    public void setActiveCell(CellAddress address) {

    }

    @Override
    public Iterator<Row> iterator() {
        return null;
    }
}
