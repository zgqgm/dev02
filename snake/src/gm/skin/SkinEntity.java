package gm.skin;

import gm.util.UrlUtil;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public abstract class SkinEntity {
        //头部图片
        private ImageIcon header = new ImageIcon(new UrlUtil().getUrl("蛇.png"));
        //身体
        private ImageIcon body = new ImageIcon(new UrlUtil().getUrl("彩带.png"));
        //食物
        private ImageIcon food = new ImageIcon(new UrlUtil().getUrl("老鼠.png"));

        /**
         * headerWidth — 头部节点宽
         * bodyWidth  — 身体节点宽
         * foodWidth — 食物节点宽
         * headerHeight — 头部节点高
         * bodyHeight — 身体节点高
         * foodHeight — 食物节点高
         * 默认大小：25
         */

        private int headerWidth = 25;
        private int bodyWidth = 25;
        private int foodWidth = 25;
        private int headerHeight = 25;
        private int bodyHeight = 25;
        private int foodHeight = 25;

        /**
         * 设置头部节点图像对象
         * @param headerUrl 图片相对路径
         */
        public void setHeader(URL headerUrl) {
                if (headerUrl != null){
                        header = new ImageIcon(headerUrl);
                }

        }

        /**
         * 设置身体节点图像对象
         * @param bodyUrl 图片相对路径
         */
        public void setBody(URL bodyUrl) {
                if (bodyUrl != null){
                        body = new ImageIcon(bodyUrl);
                }
        }

        /**
         * 设置食物节点图像对象
         * @param foodUrl 图片相对路径
         */
        public void setFood(URL foodUrl) {
                if (foodUrl != null){
                        food = new ImageIcon(foodUrl);
                }
        }

        /**
         * 设置食物节点大小
         * @param size 大小
         */
        public void setFoodSize(int size) {
                this.foodWidth = size;
                this.foodHeight = size;
        }

        /**
         * 设置食物节点宽高
         * @param width 宽
         * @param height 高
         */
        public void setFoodSize(int width,int height) {
                this.foodWidth = width;
                this.foodHeight = height;
        }

        /**
         * 设置头部节点大小
         * @param size 大小
         */
        public void setHeaderSize(int size) {
                this.headerWidth = size;
                this.headerHeight = size;
        }

        /**
         * 设置头部节点宽高
         * @param width 宽
         * @param height 高
         */
        public void setHeaderSize(int width,int height) {
                this.headerWidth = width;
                this.headerHeight = height;
        }

        /**
         * 设置身体节点大小
         * @param size 大小
         */
        public void setBodySize(int size) {
                this.bodyWidth = size;
                this.bodyHeight = size;
        }

        /**
         * 设置身体节点宽高
         * @param width 宽
         * @param height 高
         */
        public void setBodySize(int width,int height) {
                this.bodyWidth = width;
                this.bodyHeight = height;
        }

        public ImageIcon getHeader() {
                return setImageSize(header,headerWidth,headerHeight);
        }

        public ImageIcon getBody() {
                return setImageSize(body,bodyWidth,bodyHeight);
        }

        public ImageIcon getFood() {
                return setImageSize(food,foodWidth,foodHeight);
        }

        public ImageIcon setImageSize(ImageIcon imageIcon,int width,int height){
                return new ImageIcon(imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        }
}
