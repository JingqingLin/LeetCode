import java.util.Arrays;

public class Solution {
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        // (y1 - y2) * X + (x2 - x1) * Y + x1 * y2 - x2 * y1 = 0
        int a1, b1, c1, a2, b2, c2;
        a1 = start1[1] - end1[1];
        b1 = end1[0] - start1[0];
        c1 = start1[0] * end1[1] - start1[1] * end1[0];
        a2 = start2[1] - end2[1];
        b2 = end2[0] - start2[0];
        c2 = start2[0] * end2[1] - start2[1] * end2[0];

        int[] line1X = new int[2], line1Y = new int[2];
        line1X[0] = Math.max(start1[0], end1[0]);
        line1X[1] = Math.min(start1[0], end1[0]);
        line1Y[0] = Math.max(start1[1], end1[1]);
        line1Y[1] = Math.min(start1[1], end1[1]);
        int[] line2X = new int[2], line2Y = new int[2];
        line2X[0] = Math.max(start2[0], end2[0]);
        line2X[1] = Math.min(start2[0], end2[0]);
        line2Y[0] = Math.max(start2[1], end2[1]);
        line2Y[1] = Math.min(start2[1], end2[1]);

        // 平行
        if (a2 * b1 - a1 * b2 == 0) {
            // 位于同一直线
            // 无斜率
            if (b1 == 0 && b2 == 0) {
                if (c1 == c2) {
                    if (line1Y[1] <= line2Y[1]) {
                        // 无包含
                        if (line1Y[0] <= line2Y[0]) {
                            // 有重叠
                            if (line1Y[0] >= line2Y[1]) {
                                double x = line2X[1] * 1.0;
                                double y = line2Y[1] * 1.0;
                                return new double[]{x, y};
                            } else {
                                return new double[0];
                            }
                        } else {
                            double x = line2X[1] * 1.0;
                            double y = line2Y[1] * 1.0;
                            return new double[]{x, y};
                        }
                    } else {
                        if (line2Y[0] <= line1Y[0]) {
                            if (line2Y[0] >= line1Y[1]) {
                                double x = line1X[1] * 1.0;
                                double y = line1Y[1] * 1.0;
                                return new double[]{x, y};
                            } else {
                                return new double[0];
                            }
                        } else {
                            double x = line1X[1] * 1.0;
                            double y = line1Y[1] * 1.0;
                            return new double[]{x, y};
                        }
                    }
                } else {
                    return new double[0];
                }
            } else {
                if (c2 * a1 == c1 * a2) {
                    // 线段 1 小于 线段 2 （无包含）
                    if (line1X[1] <= line2X[1]) {
                        // 无包含
                        if (line1X[0] <= line2X[0]) {
                            // 有重叠
                            if (line1X[0] >= line2X[1]) {
                                double x = line2X[1] * 1.0;
                                double y = (-a2 * x - c2) / b2;
                                return new double[]{x, y};
                            } else {
                                return new double[0];
                            }
                        } else {
                            double x = line2X[1] * 1.0;
                            double y = (-a2 * x - c2) / b2;
                            return new double[]{x, y};
                        }
                    } else {
                        if (line2X[0] <= line1X[0]) {
                            if (line2X[0] >= line1X[1]) {
                                double x = line1X[1] * 1.0;
                                double y = (-a2 * x - c2) / b2;
                                return new double[]{x, y};
                            } else {
                                return new double[0];
                            }
                        } else {
                            double x = line1X[1] * 1.0;
                            double y = (-a2 * x - c2) / b2;
                            return new double[]{x, y};
                        }
                    }
                } else {
                    return new double[0];
                }
            }
        } else {
            double[] inter = new double[2];
            inter[0] = (b1 * c2 - b2 * c1) * 1.0 / (a1 * b2 - a2 * b1);
            inter[1] = (a1 * c2 - a2 * c1) * 1.0 / (a2 * b1 - a1 * b2);

            if (inter[0] >= line1X[1] && inter[0] <= line1X[0] && inter[1] >= line1Y[1] && inter[1] <= line1Y[0]) {
                if (inter[0] >= line2X[1] && inter[0] <= line2X[0] && inter[1] >= line2Y[1] && inter[1] <= line2Y[0]) {
                    return inter;
                }
            }
            return new double[0];
        }
    }

    public static void main(String[] args) {
        int[] start1 = new int[]{0, 0};
        int[] end1 = new int[]{0, 1};
        int[] start2 = new int[]{0, 0};
        int[] end2 = new int[]{0, 3};
        System.out.println(Arrays.toString(intersection(start1, end1, start2, end2)));
    }
}
