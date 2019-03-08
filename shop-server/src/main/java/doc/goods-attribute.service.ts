export interface GoodsAttributeReqModel {
        // 主键
        id?:  number;
        // 产品属性分类ID
        productAttributeCategoryId?:  number;
        // 名称
        name?: string;
        // 属性选择类型：0->唯一；1->单选；2->多选
        selectType?:  number;
        // 属性录入方式：0->手工录入；1->从列表中选取
        inputType?:  number;
        // 可选值列表，以逗号隔开
        inputList?: string;
        // 排序字段：最高的可以单独上传图片
        sort?:  number;
        // 分类筛选样式：1->普通；1->颜色
        filterType?:  number;
        // 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
        searchType?:  number;
        // 相同属性产品是否关联；0->不关联；1->关联
        relatedStatus?:  number;
        // 是否支持手动新增；0->不支持；1->支持
        handAddStatus?:  number;
        // 属性的类型；0->规格；1->参数
        type?:  number;
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
export namespace GoodsAttributeServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsAttributeServiceClass {
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
        public getGoodsAttributeList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttribute/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoodsAttribute(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttribute/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoodsAttribute(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttribute/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsAttributeDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goodsAttribute/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoodsAttribute(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttribute/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goodsAttribute/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsAttributeService extends GoodsAttributeServiceNs.GoodsAttributeServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

