import { storeFormData,readFormDataList } from "../asyncStorageUtil/asyncStorageutil";

const initialState = {
  formDataList: [],
};

const reducer = async (state = initialState, action) => {
  switch (action.type) {
    case 'UPDATE_FORM':
      const updatedFormDataList = [...state.formDataList, action.formData];
      await storeFormData(updatedFormDataList);
      return {
        ...state,
        formDataList: updatedFormDataList,
      };
    case 'FETCH_FORM_DATA':
      const formDataList = await fetchFormDataList();
      return {
        ...state,
        formDataList,
      };
    default:
      return state;
  }
};

export default reducer;
