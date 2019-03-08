export interface GoodsReqModel {
        // pk
        id?:  number;
        // 品牌ID
        brandId?:  number;
        // 类目id
        productCategoryId?:  number;
        // 运费模板
        feightTemplateId?:  number;
        // 属性分类id
        productAttributeCategoryId?:  number;
        // 名称
        name?: string;
        // 图片
        pic?: string;
        // 货号
        productSn?: string;
        // 删除状态：0->未删除；1->已删除
        deleteStatus?:  number;
        // 上架状态：0->下架；1->上架
        publishStatus?:  number;
        // 新品状态:0->不是新品；1->新品
        newStatus?:  number;
        // 推荐状态；0->不推荐；1->推荐
        recommandStatus?:  number;
        // 审核状态：0->未审核；1->审核通过
        verifyStatus?:  number;
        // 排序
        sort?:  number;
        // 销量
        sale?:  number;
        // 价格
        price?:  number;
        // 促销价格
        promotionPrice?:  number;
        // 赠送的成长值
        giftGrowth?:  number;
        // 赠送的积分
        giftPoint?:  number;
        // 限制使用的积分数
        usePointLimit?:  number;
        // 副标题
        subTitle?: string;
        // 商品描述
        description?: string;
        // 市场价
        originalPrice?:  number;
        // 库存
        stock?:  number;
        // 库存预警值
        lowStock?:  number;
        // 单位
        unit?: string;
        // 商品重量，默认为克
        weight?:  number;
        // 是否为预告商品：0->不是；1->是
        previewStatus?:  number;
        // 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
        serviceIds?: string;
        // 关键词
        keywords?: string;
        // 备注
        note?: string;
        // 画册图片，连产品图片限制为5张，以逗号分割
        albumPics?: string;
        // 详细标题
        detailTitle?: string;
        // 详情描述
        detailDesc?: string;
        // 产品详情网页内容
        detailHtml?: string;
        // 移动端网页详情
        detailMobileHtml?: string;
        // 促销开始时间
        promotionStartTime?: Date;
        // 促销结束时间
        promotionEndTime?: Date;
        // 活动限购数量
        promotionPerLimit?:  number;
        // 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
        promotionType?:  number;
        // 品牌名称
        brandName?: string;
        // 商品分类名称
        productCategoryName?: string;
        // 创建人
        dbCreateAuthor?: string;
        // 创建时间
        dbCreateTime?: Date;
        // 更新人
        dbUpdateAuthor?: string;
        // 更新时间
        dbUpdateTime?: Date;
}

##############################################################################################

import { Injectable, Injector } from '@angular/core';
import { HttpUtilNs, HttpUtilService } from '../infra/http/http-util.service';
import { Observable } from 'rxjs/Observable';
export namespace GoodsServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsServiceClass {
        private http: HttpUtilService;
        private defaultConfig: HttpUtilNs.UfastHttpConfig;
        private barcodeFlagList: { value: number, label: string }[];
        private returnState: { value: number, label: string }[];
        constructor(private injector: Injector) {
            this.http = this.injector.get(HttpUtilService);
            this.defaultConfig = {
                gateway: HttpUtilNs.GatewayKey.Ss
            };
            this.barcodeFlagList = [
                { label: '否', value: 0 },
                { label: '是', value: 1 }
            ];
        }
        public getBarcodeList(): Observable<any> {
            return Observable.of(this.barcodeFlagList);
        }

        /**列表 */
        public getGoodsList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goods/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoods(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goods/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoods(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goods/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goods/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoods(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goods/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goods/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsService extends GoodsServiceNs.GoodsServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

